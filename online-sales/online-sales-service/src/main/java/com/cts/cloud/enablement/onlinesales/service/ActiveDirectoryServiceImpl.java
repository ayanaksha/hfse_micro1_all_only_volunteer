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
	ActiveDirectoryRepository ActiveDirectoryRepository;

	@Override
	public ActiveDirectory retrieveUserByEmpID(ActiveDirectory user) {
		return ActiveDirectoryRepository.findByEmpID(user.getEmpid());
	}
	
	@Override
	public ActiveDirectory retrieveUserByEmailId(ActiveDirectory user) {
		return ActiveDirectoryRepository.findByUserEmailId(user.getUserEmailId());
	}
	
	@Override
	public ActiveDirectory retrieveUserByEmpIDAndPassword(ActiveDirectory user) {
		return ActiveDirectoryRepository.findByEmpIDAndPassword(user.getEmpid(), user.getPassword());
	}

	@Override
	public ActiveDirectory createNewUser(ActiveDirectory user) {
		ActiveDirectory existingUser = ActiveDirectoryRepository.findByEmpID(user.getEmpid());
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
		ActiveDirectoryRepository.save(newUser);
		return newUser;
	}

	
	@Override
	public ActiveDirectory updateUserRole(ActiveDirectory user) {
		SalesUser existingUser = salesUserRepository.findByEmpID(user.getEmpid());
		
		existingUser.setRole(user.getRole());
		
		ActiveDirectoryRepository.save(existingUser);
		return existingUser;
	}


	@Override
	public List<ActiveDirectory> retrieveEmpByProj(ActiveDirectory requestUser) {
		return ActiveDirectoryRepository.findByProjID(requestUser.getProjId());
	}
	
	
}