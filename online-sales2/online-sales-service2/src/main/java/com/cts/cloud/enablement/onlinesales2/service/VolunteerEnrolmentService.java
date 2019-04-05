package com.cts.cloud.enablement.onlinesales2.service;

import java.util.List;

import com.cts.cloud.enablement.onlinesales2.domain.VolunteerEnrolment;

/**
 * @author 547991
 *
 */
public interface VolunteerEnrolmentService {

	List<VolunteerEnrolment> retrieveEnrolmentByEmpID(Long empID);
//	
	List<VolunteerEnrolment> retrieveEnrolmentByStatus(String Status);
//	
//	SalesUser retrieveUserByEmpIDAndPassword(SalesUser user);
//	
	VolunteerEnrolment createNewVolunteerEnrolment(VolunteerEnrolment volunteerEnrolment);
//	
//	SalesUser updateUserRole(SalesUser user);
//	
//	List<SalesUser> retrieveEmpByProj(SalesUser user);
	
}