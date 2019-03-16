package com.cts.cloud.enablement.onlinesales.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.cloud.enablement.onlinesales.domain.EventRegistration;
import com.cts.cloud.enablement.onlinesales.domain.ActiveDirectory;
import com.cts.cloud.enablement.onlinesales.domain.EventSummary;
import com.cts.cloud.enablement.onlinesales.service.EventSummaryService;
import com.cts.cloud.enablement.onlinesales.domain.VolunteerRegistration;
import com.cts.cloud.enablement.onlinesales.service.VolunteerRegistrationService;
import com.cts.cloud.enablement.onlinesales.service.EventRegistrationService;
import com.cts.cloud.enablement.onlinesales.service.ActiveDirectoryService;
import com.cts.cloud.enablement.onlinesales.service.SecurityTokenGenerator;

/**
 * @author 547991
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1")
public class SalesController {

	@Autowired
	ActiveDirectoryService activeDirectoryService;
	
	@Autowired
	EventRegistrationService eventRegistrationService;
	
	@Autowired
	EventSummaryService eventSummaryService;
	
	@Autowired
	VolunteerRegistrationService volunteerRegistrationService;
	
	@Autowired
	private SecurityTokenGenerator tokenGenerator;
	
	@GetMapping("/testApi")
    public String testApi(){
        return "Testing App Success";
    }
	
	/**
	 * method to retrieve a user object from database by its username
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/login")
	public ResponseEntity<?> retrieveUserById(@RequestBody final ActiveDirectory user, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		Map<String, Object> map = new HashMap<String, Object>(); 
		ActiveDirectory thisUser = null;
		try {
			thisUser = activeDirectoryService.retrieveUserByEmpIDAndPassword(user);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		if(thisUser != null) {
			map = tokenGenerator.generateToken(thisUser);
		}
		map.put("loggedInUser", thisUser);
		responseEntity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * method to create a user object
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/registerUser")
	public ResponseEntity<?> createUser(@RequestBody final ActiveDirectory user, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		ActiveDirectory thisUser = null;
		try {
			thisUser = activeDirectoryService.createNewUser(user);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<ActiveDirectory>(thisUser, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * method to retrieve event registration based on employee id
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/eventRegistrationForUser")
	public @ResponseBody ResponseEntity<?> eventRegistrationForUser(@RequestBody final ActiveDirectory user, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<EventRegistration> eventRegistrationList = null;
		try {
			eventRegistrationList = eventRegistrationService.retrieveEventRegistrationByEmpID(user.getEmpid());
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<EventRegistration>>(eventRegistrationList, HttpStatus.OK);
	}
	
	
	/**
	 * method to retrieve all event registrations
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/allEventRegistration")
	public @ResponseBody ResponseEntity<?> allEventRegistration(final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<EventRegistration> eventRegistrationList = null;
		try {
			eventRegistrationList = eventRegistrationService.retrieveAllEventRegistration();
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<EventRegistration>>(eventRegistrationList, HttpStatus.OK);
	}

	/**
	 * method to register for an event
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/registerForAnEvent")
	public ResponseEntity<?> eventRegistration(@RequestBody final eventRegistration eventReg, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		EventRegistration thisEvent = null;
		try {
			thisEvent = eventRegistrationService.createEventRegistration(eventReg);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<EventRegistration>(thisEvent, HttpStatus.OK);
		return responseEntity;
	}
	
	
	/**
	 * method to retrieve events organized by a POC
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/eventcreatedByPOC")
	public @ResponseBody ResponseEntity<?> eventCreatedByPOC(@RequestBody final ActiveDirectory user, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List<EventSummary> eventSummaryList = null;
		try {
			eventSummaryList = eventSummaryService.retrieveEventByPoc(user.getEmpid());
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<EventSummary>>(eventSummaryList, HttpStatus.OK);
	}
	
	
	/**
	 * method to create a new event
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/createEvent")
	public ResponseEntity<?> createEvent(@RequestBody final eventSummary eventSum, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		EventSummary thisEvent = null;
		try {
			thisEvent = eventSummaryService.createEvent(eventSum);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<EventSummary>(thisEvent, HttpStatus.OK);
		return responseEntity;
	}
	
	/**
	 * method to create new events in bulk
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(path = "/online-sales-service/createEvent")
	public ResponseEntity<?> createEvents(@RequestBody final List<EventSummary> eventSum, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		List <EventSummary> thisEvent = null;
		try {
			thisEvent = eventSummaryService.createEvents(eventSum);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		responseEntity = new ResponseEntity<EventSummary>(thisEvent, HttpStatus.OK);
		return responseEntity;
	}
	/**
	 * method to retrieve transaction for relationmanager from database by user details
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
//	@PostMapping(path = "/online-sales-service/retrievePOCTransactions")
//	public @ResponseBody ResponseEntity<?> retrievePOCTransactionDetails(@RequestBody final ActiveDirectory user, final HttpServletRequest request,
//			final HttpServletResponse response) {
//		ResponseEntity<?> responseEntity;
//		List<EventSummaryRegistration> salesPOCTransactionList = null;
//		try {
//			salesPOCTransactionList = EventSummaryRegistrationService.retrievePocTransactions(user.getId());
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<List<EventSummaryRegistration>>(salesPOCTransactionList, HttpStatus.OK);
//	}
//	
//	/**
//	 * method to create a transaction
//	 * @param EventSummaryRegistrationDetails
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@PostMapping(path = "/online-sales-service/submitTransaction")
//	public @ResponseBody ResponseEntity<?> createTransactionDetails(@RequestBody final EventSummaryRegistration EventSummaryRegistrationDetails, final HttpServletRequest request,
//			final HttpServletResponse response) {
//		ResponseEntity<?> responseEntity;
//		EventSummaryRegistration EventSummaryRegistrationList = null;
//		ActiveDirectory requestedActiveDirectory = new ActiveDirectory();
//		try {
//			requestedActiveDirectory.setEmpid(EventSummaryRegistrationDetails.getPocID());
//			requestedActiveDirectory = ActiveDirectoryService.retrieveUserByEmpID(requestedActiveDirectory);
//			if(requestedActiveDirectory == null) {
//				throw new Exception("Couldn't find poc");
//			}
//
////			Optional<ActiveDirectory> relationManager = ActiveDirectoryService.retrieveRMByUser(requestedActiveDirectory).stream().findFirst();
////			relationManager.orElseThrow(() -> new Exception("Couldn't find RM with user email id"));
//			
////			EventSummaryRegistrationDetails.setRequestedBy(requestedActiveDirectory.getUserEmailId());
////			EventSummaryRegistrationDetails.setRmEmailId(relationManager.get().getUserEmailId());
//			EventSummaryRegistrationList = EventSummaryRegistrationService.createTransaction(EventSummaryRegistrationDetails);
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<EventSummaryRegistration>(EventSummaryRegistrationList, HttpStatus.OK);
//	}
//	
//	@PostMapping(path = "/online-sales-service/createEventSummary")
//	public @ResponseBody ResponseEntity<?> createEventSummaryDetails(@RequestBody final List<EventSummary> EventSummaryDetails, final HttpServletRequest request,
//			final HttpServletResponse response) {
//		ResponseEntity<?> responseEntity;
//		List<EventSummary> EventSummaryList = null; 
//		try {EventSummaryList = EventSummaryService.createEventSummarys(EventSummaryDetails);
//			if(EventSummaryList == null) {
//				throw new Exception("Couldn't create EventSummary");
//		} 
//		}catch (Exception e) {
//			e.printStackTrace();
//			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//		return new ResponseEntity<List<EventSummary>>(EventSummaryList, HttpStatus.OK);
//	}
//		
//	/**
//	 * method to save approval of a transaction
//	 * @param EventSummaryRegistrationDetails
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@PostMapping(path = "/online-sales-service/submitTransactionApproval")
//	public @ResponseBody ResponseEntity<?> submitTransactionApproval(@RequestBody final List<EventSummaryRegistration> EventSummaryRegistrationDetails, final HttpServletRequest request,
//			final HttpServletResponse response) {
//		ResponseEntity<?> responseEntity;
//		List<EventSummaryRegistration> EventSummaryRegistrationList = null; 
//		try {
//			EventSummaryRegistrationList = EventSummaryRegistrationService.updateTransaction(EventSummaryRegistrationDetails);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		return new ResponseEntity<List<EventSummaryRegistration>>(EventSummaryRegistrationList, HttpStatus.OK);
//	}
//	
//	/**
//	 * method to submit payment for a transaction
//	 * @param EventSummaryRegistrationDetails
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@PostMapping(path = "/online-sales-service/submitPaidTransaction")
//	public @ResponseBody ResponseEntity<?> submitPaidTransaction(@RequestBody final EventSummaryRegistration EventSummaryRegistrationDetails, final HttpServletRequest request,
//			final HttpServletResponse response) {
//		ResponseEntity<?> responseEntity;
//		List<EventSummaryRegistration> EventSummaryRegistrationList = null; 
//		EventSummaryRegistrationList = EventSummaryRegistrationService.updateTransaction(EventSummaryRegistrationDetails); 
//		return new ResponseEntity<List<EventSummaryRegistration>>(EventSummaryRegistrationList, HttpStatus.OK);
//	}
}