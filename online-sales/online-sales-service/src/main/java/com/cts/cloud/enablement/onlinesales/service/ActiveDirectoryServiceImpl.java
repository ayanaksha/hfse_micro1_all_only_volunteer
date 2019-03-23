package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cloud.enablement.onlinesales.domain.ActiveDirectory;
import com.cts.cloud.enablement.onlinesales.repository.ActiveDirectoryRepository;

/**
 * @author 547991
 *
 */
@Service
public class ActiveDirectoryServiceImpl implements ActiveDirectoryService {
	
	@Autowired
	ActiveDirectoryRepository activeDirectoryRepository;

	@Override
	public ActiveDirectory retrieveUserByEmpID(ActiveDirectory user) {
		return activeDirectoryRepository.findByEmpid(user.getEmpid());
	}
	
	@Override
	public ActiveDirectory retrieveUserByEmailId(ActiveDirectory user) {
		return activeDirectoryRepository.findByUserEmailId(user.getUserEmailId());
	}
	
	@Override
	public ActiveDirectory retrieveUserByEmpIDAndPassword(ActiveDirectory user) {
		return activeDirectoryRepository.findByEmpidAndPassword(user.getEmpid(), user.getPassword());
	}

	@Override
	public ActiveDirectory createNewUser(ActiveDirectory user) {
		ActiveDirectory existingUser = activeDirectoryRepository.findByEmpid(user.getEmpid());
		ActiveDirectory newUser = new ActiveDirectory();
		if(existingUser == null) {
			newUser.setEmpid(user.getEmpid());
			newUser.setPassword(user.getPassword());
			newUser.setEmpname(user.getEmpname());
			newUser.setUserEmailId(user.getUserEmailId());
			newUser.setBuid(user.getBuid());
			newUser.setProjId(user.getProjId());
			newUser.setRole(user.getRole());
		}
		activeDirectoryRepository.save(newUser);
		return newUser;
	}

	
	@Override
	public ActiveDirectory updateUserRole(ActiveDirectory user) {
		ActiveDirectory existingUser = activeDirectoryRepository.findByEmpid(user.getEmpid());
		
		existingUser.setRole(user.getRole());
		
		activeDirectoryRepository.save(existingUser);
		return existingUser;
	}


	@Override
	public List<ActiveDirectory> retrieveEmpByProj(ActiveDirectory requestUser) {
		return activeDirectoryRepository.findByProjId(requestUser.getProjId());
	}
	
	
}