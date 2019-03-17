package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cloud.enablement.onlinesales.domain.VolunteerEnrolment;
import com.cts.cloud.enablement.onlinesales.repository.VolunteerEnrolmentRepository;

/**
 * @author 547991
 *
 */
@Service
public class VolunteerEnrolmentServiceImpl implements VolunteerEnrolmentService {
	
	@Autowired
	VolunteerEnrolmentRepository volunteerEnrolmentRepository;

	@Override
	public List<VolunteerEnrolment> retrieveEnrolmentByEmpID(Long empID) {
		return volunteerEnrolmentRepository.findByEmpID(empID);
	}
	
	@Override
	public List<VolunteerEnrolment> retrieveEnrolmentByStatus(String status) {
		return volunteerEnrolmentRepository.findByStatus(status);
	}
	
//	@Override
//	public SalesUser retrieveUserByEmpIDAndPassword(SalesUser user) {
//		return salesUserRepository.findByEmpIDAndPassword(user.getEmpid(), user.getPassword());
//	}

	@Override
	public VolunteerEnrolment createNewVolunteerEnrolment(VolunteerEnrolment volunteerEnrolment) {
//		VolunteerEnrolment existingVolunteerEnrolment = volunteerEnrolmentRepository.findByEmpID(user.getEmpid());
//		SalesUser newUser = new SalesUser();
//		if(existingUser == null) {
//			newUser.setEmpid(user.getEmpid());
//			newUser.setPassword(user.getPassword());
//			newUser.setEmpname(user.getEmpname());
//			newUser.setUserEmailId(user.getUserEmailId());
//			newUser.setPhone(user.getPhone());
//			newUser.setProjId(user.getProjId());
//			newUser.setProjname(user.getProjname());
//			newUser.setLocation(user.getLocation());
//			newUser.setRole(user.getRole());
//		}
		volunteerEnrolmentRepository.save(volunteerEnrolment);
		return volunteerEnrolment;
	}

	
//	@Override
//	public SalesUser updateUserRole(SalesUser user) {
//		SalesUser existingUser = salesUserRepository.findByEmpID(user.getEmpid());
//		
//		existingUser.setRole(user.getRole());
//		
//		salesUserRepository.save(existingUser);
//		return existingUser;
//	}
	
//	@Override
//	public SalesUser retrieveUserByUserEmailIdAndPassword(SalesUser user) {
//		return salesUserRepository.findByUserEmailIdAndPassword(user.getUserEmailId(), user.getPassword());
//	}

//	@Override
//	public List<SalesUser> retrieveEmpByProj(SalesUser requestUser) {
//		return salesUserRepository.findByProjID(requestUser.getProjId());
//	}
	
	
}