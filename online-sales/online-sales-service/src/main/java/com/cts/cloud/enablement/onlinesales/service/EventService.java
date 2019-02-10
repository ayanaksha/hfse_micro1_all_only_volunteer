package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import com.cts.cloud.enablement.onlinesales.domain.Event;

/**
 * @author 547991
 *
 */
public interface EventService {
	
	List<Event> retrieveEventByPoc(Long pocID);
	
	List<Event> retrieveEventByLocation(String location);
	
	Event createEvent(Event event) throws Exception;
	
	List<Event> createEvents(List<Event> event) throws Exception;
	
	Event updateEventStatus(Long eventID, String status);
	
	Event updateLivesTouched(Long eventID, Long livesTouched);
	
}
