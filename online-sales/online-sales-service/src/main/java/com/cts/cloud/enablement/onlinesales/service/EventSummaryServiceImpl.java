package com.cts.cloud.enablement.onlinesales.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cloud.enablement.onlinesales.domain.EventSummary;
import com.cts.cloud.enablement.onlinesales.domain.ActiveDirectory;
import com.cts.cloud.enablement.onlinesales.repository.EventSummaryRepository;
import com.cts.cloud.enablement.onlinesales.repository.ActiveDirectoryRepository;

/**
 * @author 547991
 *
 */
@Service
public class EventSummaryServiceImpl implements EventSummaryService {

	@Autowired
	private transient EventSummaryRepository eventSummaryRepository;
	
	@Autowired
	private transient ActiveDirectoryRepository activeDirectoryRepository;
	
	@Override
	public List<EventSummary> retrieveEventByPoc(Long pocID) {
		return eventSummaryRepository.findByPocID(pocID);
	}

//	@Override
//	public List<Event> retrieveEventByLocation(String location) {
//		return eventRepository.findByLocationOrderByEventTimeAsc(location);
//	}
	
	@Override
	public EventSummary createEvent(EventSummary eventSummary) {
//		eventSummary.setCreationDate(new Date().toString());
		eventSummaryRepository.save(eventSummary);
		return eventSummary;
	}
	
	@Override
	public List<EventSummary> createEvents(List<EventSummary> eventList) {
//		eventList.setCreationDate(new Date().toString());
//		eventRepository.save(event);
//		return eventRepository.findByID(event.getEventID());
		
//		for(EventSummary eachRecord : eventList) {
//		//fetch user id by invoking DB with username
//	    eachRecord.setCreationDate(new Date().toString());
//		
//	}
	eventSummaryRepository.saveAll(eventList);
	return eventList;
	}
	
	@Override
	public EventSummary updateEventSummary(Long eventID, EventSummary eventSummary) {
		EventSummary event = eventSummaryRepository.findByEventId(eventID); 
		event.setEventDate(eventSummary.getEventDate);
		event.setEventDesc(eventSummary.getEventDesc);
		event.setStatus(eventSummary.getStatus);
		event.setStartTime(eventSummary.getStartTime);
		event.setEndTime(eventSummary.getEndTime);
		event.setBoardingPoints(eventSummary.getBoardingPoints);
		event.setDropPoints(eventSummary.getDropPoints);
		event.setLivesTouched(eventSummary.getLivesTouched);
		eventSummaryRepository.save(event);
		return event;
	}
	
//	@Override
//	public Event updateLivesTouched(Long eventID, Long livesTouched) {
//		Event event = eventRepository.findByID(eventID); 
//		event.setlivesTouched(livesTouched);
//		eventRepository.save(event);
//		return eventRepository.findByID(eventID);
//	}
	

	
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
