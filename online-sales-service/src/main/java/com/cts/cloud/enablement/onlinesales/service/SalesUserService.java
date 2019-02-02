package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import com.cts.cloud.enablement.onlinesales.domain.SalesUser;

/**
 * @author 547991
 *
 */
public interface SalesUserService {

	SalesUser retrieveUserByUsername(SalesUser user);
	
	SalesUser retrieveUserByEmailId(SalesUser user);
	
	SalesUser retrieveUserByUsernameAndPassword(SalesUser user);
	
	SalesUser retrieveUserByUserEmailIdAndPassword(SalesUser user);
	
	SalesUser createNewUser(SalesUser user);
	
	List<SalesUser> retrieveRMByUser(SalesUser user);
}