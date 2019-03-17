package com.cts.cloud.enablement.onlinesales.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.cloud.enablement.onlinesales.domain.EventRegistration;

/**
 * @author 547991
 *
 */
public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {
	
	List<EventRegistration> findByEmpID(Long empID);
	
//	List<SalesTransaction> findByPocIDOrderByStatusAsc(Long pocID);
	
//	List<SalesTransaction> findByEmpIDAndStatus(Long empID, String status);
//	
	List<EventRegistration> findByEventID(Long eventID);
//	
	EventRegistration findByEmpIDAndEventDate(Long empID, String eventDate);
//	
//	List<SalesTransaction> findByEmpID(Long empID);
//	
	List<EventRegistration> findByProjID(Long ProjID);
//	
//	List<SalesTransaction> findByEmpIDIn(List<Long> userList);
//	
//	List<SalesTransaction> findByPocIDInAndStatus(List<Long> userList, String status);
//	
//	List<SalesTransaction> findByEventIDIn(List<Long> eventList);
//	
//	List<SalesTransaction> findByEventID(Long eventID);
	
//	SalesTransaction findById(int id);
}