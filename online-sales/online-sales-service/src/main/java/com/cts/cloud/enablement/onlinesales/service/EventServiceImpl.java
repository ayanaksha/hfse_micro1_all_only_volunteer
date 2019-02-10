package com.cts.cloud.enablement.onlinesales.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cloud.enablement.onlinesales.domain.Event;
import com.cts.cloud.enablement.onlinesales.domain.SalesUser;
import com.cts.cloud.enablement.onlinesales.repository.EventRepository;
import com.cts.cloud.enablement.onlinesales.repository.SalesUserRepository;

/**
 * @author 547991
 *
 */
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private transient EventRepository eventRepository;
	
	@Autowired
	private transient SalesUserRepository salesUserRepository;
	
	@Override
	public List<Event> retrieveEventByPoc(Long pocID) {
		return eventRepository.findByPocIDOrderByEventTimeAsc(pocID);
	}

	@Override
	public List<Event> retrieveEventByLocation(String location) {
		return eventRepository.findByLocationOrderByEventTimeAsc(location);
	}
	
	@Override
	public Event createEvent(Event event) {
		event.setCreationDate(new Date().toString());
		eventRepository.save(event);
		return eventRepository.findByID(event.getEventID());
	}
	
	@Override
	public List<Event> createEvents(List<Event> eventList) {
		event.setCreationDate(new Date().toString());
		eventRepository.save(event);
		return eventRepository.findByID(event.getEventID());
		
		for(Event eachRecord : eventList) {
		//fetch user id by invoking DB with username
	    eachRecord.setCreationDate(new Date().toString());
		
	}
	eventRepository.saveAll(eventList);
	return eventRepository.findByIDs(eventList.get(0).getEventID());
	}
	
	@Override
	public Event updateEventStatus(Long eventID, String status) {
		Event event = eventRepository.findById(eventID); 
		event.setStatus(status);
		eventRepository.save(event);
		return eventRepository.findByID(eventID);
	}
	
	@Override
	public Event updateLivesTouched(Long eventID, Long livesTouched) {
		Event event = eventRepository.findByID(eventID); 
		event.setlivesTouched(livesTouched);
		eventRepository.save(event);
		return eventRepository.findByID(eventID);
	}
	

	
//	@Override
//	public List<SalesTransaction> retrievePocTransactions(Long pocID) {
//		SalesUser currentRelationManager = salesUserRepository.findByUserEmailId(userEmailId);
//		List<SalesUser> salesUser = salesUserRepository.findByRoleAndLocation("user", currentRelationManager.getLocation());
//		
//		List<String> listOfUserEmailIds = salesUser.stream().map(SalesUser::getUserEmailId).map(Object::toString).collect(Collectors.toList());
//		
//		List<SalesTransaction> salesRelationshipManagerTransactionList = salesTransactionRepository.findByRequestedByInAndStatus(listOfUserEmailIds, "OPEN");
//		
//		salesRelationshipManagerTransactionList.forEach( salesRM -> {
//			salesUser.forEach( sales -> {
//				if(salesRM.getRequestedBy().equals(sales.getUserEmailId())) {
//					salesRM.setRequestedBy(sales.getUserEmailId());
//				}
//			});
//		});		
//		return salesRelationshipManagerTransactionList;
//	}

}
