package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import com.cts.cloud.enablement.onlinesales.domain.EventRegistration;

/**
 * @author 547991
 *
 */
public interface EventRegistrationService {
	
	List<EventRegistration> retrieveEventRegistrationByEmpID(Long empID);
	
	List<EventRegistration> retrieveAllEventRegistration();
	
	List<EventRegistration> retrieveEventRegistrationByProjID(Long projID);
//	
//	List<SalesTransaction> retrievePocTransactions(Long pocID);
//	
//	List<SalesTransaction> retrieveEventTransactions(Long eventID);

	EventRegistration createEventRegistration(EventRegistration eventRegistration) throws Exception;
	
	List<EventRegistration> updateEventRegistrationStatus(Long eventID);
	
}
