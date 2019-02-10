package com.cts.cloud.enablement.onlinesales.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.cloud.enablement.onlinesales.domain.SalesTransaction;
import com.cts.cloud.enablement.onlinesales.domain.SalesUser;
import com.cts.cloud.enablement.onlinesales.repository.SalesTransactionRepository;
import com.cts.cloud.enablement.onlinesales.repository.SalesUserRepository;

/**
 * @author 547991
 *
 */
@Service
public class SalesTransactionServiceImpl implements SalesTransactionService {

	@Autowired
	private transient SalesTransactionRepository salesTransactionRepository;
	
	@Autowired
	private transient SalesUserRepository salesUserRepository;
	
	@Override
	public List<SalesTransaction> retrieveTransactionsByUser(Long empID) {
		SalesUser salesUser = salesUserRepository.findByEmpID(empID);
		return salesTransactionRepository.findByEmpID(salesUser.getEmpid());
	}

	@Override
	public List<SalesTransaction> retrieveTransactionsByProjID(Long projID) {
		return salesTransactionRepository.findByProjID(projID);
	}
	
	@Override
	public List<SalesTransaction> retrievePocTransactions(Long pocID) {
		return salesTransactionRepository.findByPocIDOrderByStatusAsc(pocID);
	}
	
	@Override
	public List<SalesTransaction> retrieveEventTransactions(Long eventID) {
		return salesTransactionRepository.findByEventID(eventID);
	}
	
	@Override
	public SalesTransaction createTransaction(SalesTransaction salesTransaction) throws Exception{
		SalesTransaction existingEvent salesTransactionRepository.findByEmpIDAndEventID(salesTransaction.getEmpID(),salesTransaction.getEventID());
		if(existingEvent.size() == 1) {
			throw new Exception("Already Registered for the current event");
		}
		
		SalesTransaction existingTransaction = salesTransactionRepository.findByEmpIDAndEventTime(salesTransaction.getEmpID(),salesTransaction.getEventTime());
		
		if(existingTransaction != null) {
			throw new Exception("Already Registered for an event on that date");
		}
		
		SalesUser salesUser = salesUserRepository.findByEmpID(salesTransaction.getEmpID());
		salesTransaction.setStatus("OPEN");
		salesTransaction.setEmpProjID(salesUser.getProjId());
		salesTransaction.setEmpEmailID(salesUser.getUserEmailId());
		salesTransactionRepository.save(salesTransaction);
		return salesTransactionRepository.findByEmpID(salesTransaction.getEmpID());
	}
	
	@Override
	public List<SalesTransaction> updateTransactionStatus(Long eventID) {
		SalesTransaction salesTransaction = salesTransactionRepository.findByEventID(eventID);
		salesTransaction.setStatus("cancelled");
		salesTransactionRepository.save(salesTransaction);
		return salesTransactionRepository.findByEventID(eventID);
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
//	
//	@Override
//	public List<SalesTransaction> updateTransaction(List<SalesTransaction> salesTransactionList) throws Exception {
//		if(salesTransactionList.size() < 1) {
//			throw new Exception("No data");
//		}
//		final String user = salesTransactionList.get(0).getApprover();
//		SalesUser approverDetails = salesUserRepository.findByUsername(user);
//		for(SalesTransaction eachRecord : salesTransactionList) {
//			//fetch user id by invoking DB with username
//		    eachRecord.setRequestedBy(eachRecord.getRequestedBy());
//			eachRecord.setApprovedDate(new Date().toString());
//		}
//		salesTransactionRepository.saveAll(salesTransactionList);
//		return retrieveRelationshipManagerTransactions(approverDetails.getUserEmailId());
//	}
//
//	
	

	
}
