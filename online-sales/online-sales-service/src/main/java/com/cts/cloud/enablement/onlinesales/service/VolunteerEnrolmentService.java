package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import com.cts.cloud.enablement.onlinesales.domain.VolunteerEnrolment;

/**
 * @author 547991
 *
 */
public interface VolunteerEnrolmentService {

	VolunteerEnrolment retrieveUserByEmpID(Long empID);
//	
	VolunteerEnrolment retrieveUserByStatus(String Status);
//	
//	SalesUser retrieveUserByEmpIDAndPassword(SalesUser user);
//	
	VolunteerEnrolment createNewVolunteerEnrolment(VolunteerEnrolment volunteerEnrolment);
//	
//	SalesUser updateUserRole(SalesUser user);
//	
//	List<SalesUser> retrieveEmpByProj(SalesUser user);
	
}