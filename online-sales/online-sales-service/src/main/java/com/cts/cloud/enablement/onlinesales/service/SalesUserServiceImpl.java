package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cloud.enablement.onlinesales.domain.SalesUser;
import com.cts.cloud.enablement.onlinesales.repository.SalesUserRepository;

/**
 * @author 547991
 *
 */
@Service
public class SalesUserServiceImpl implements SalesUserService {
	
	@Autowired
	SalesUserRepository salesUserRepository;

	@Override
	public SalesUser retrieveUserByUsername(SalesUser user) {
		return salesUserRepository.findByUsername(user.getUsername());
	}
	
	@Override
	public SalesUser retrieveUserByEmailId(SalesUser user) {
		return salesUserRepository.findByUserEmailId(user.getUserEmailId());
	}
	
	@Override
	public SalesUser retrieveUserByUsernameAndPassword(SalesUser user) {
		return salesUserRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}

	@Override
	public SalesUser createNewUser(SalesUser user) {
		SalesUser existingUser = salesUserRepository.findByUsername(user.getUsername());
		SalesUser newUser = new SalesUser();
		if(existingUser == null) {
			newUser.setUsername(user.getUsername());
			newUser.setPassword(user.getPassword());
			newUser.setUserEmailId(user.getUserEmailId());
			newUser.setPhone(user.getPhone());
			newUser.setLocation(user.getLocation());
			newUser.setRole("user");
		}
		salesUserRepository.save(newUser);
		return newUser;
	}

	@Override
	public SalesUser retrieveUserByUserEmailIdAndPassword(SalesUser user) {
		return salesUserRepository.findByUserEmailIdAndPassword(user.getUserEmailId(), user.getPassword());
	}

	@Override
	public List<SalesUser> retrieveRMByUser(SalesUser requestUser) {
		return salesUserRepository.findByRoleAndLocation("relationmanager", requestUser.getLocation());
	}
}