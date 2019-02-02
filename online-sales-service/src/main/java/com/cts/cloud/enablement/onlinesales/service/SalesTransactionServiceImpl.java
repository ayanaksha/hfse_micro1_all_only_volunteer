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
	public List<SalesTransaction> retrieveTransactionsByUser(String username) {
		SalesUser salesUser = salesUserRepository.findByUsername(username);
		return salesTransactionRepository.findByRequestedByOrderByStatusAsc(salesUser.getUserEmailId());
	}

	@Override
	public List<SalesTransaction> createTransaction(SalesTransaction salesTransaction) {
		salesTransaction.setStatus("OPEN");
		salesTransaction.setCreatedDate(new Date().toString());
		salesTransactionRepository.save(salesTransaction);
		return salesTransactionRepository.findByRequestedBy(salesTransaction.getRequestedBy());
	}

	@Override
	public List<SalesTransaction> retrieveRelationshipManagerTransactions(String userEmailId) {
		SalesUser currentRelationManager = salesUserRepository.findByUserEmailId(userEmailId);
		List<SalesUser> salesUser = salesUserRepository.findByRoleAndLocation("user", currentRelationManager.getLocation());
		
		List<String> listOfUserEmailIds = salesUser.stream().map(SalesUser::getUserEmailId).map(Object::toString).collect(Collectors.toList());
		
		List<SalesTransaction> salesRelationshipManagerTransactionList = salesTransactionRepository.findByRequestedByInAndStatus(listOfUserEmailIds, "OPEN");
		
		salesRelationshipManagerTransactionList.forEach( salesRM -> {
			salesUser.forEach( sales -> {
				if(salesRM.getRequestedBy().equals(sales.getUserEmailId())) {
					salesRM.setRequestedBy(sales.getUserEmailId());
				}
			});
		});		
		return salesRelationshipManagerTransactionList;
	}

	@Override
	public List<SalesTransaction> updateTransaction(List<SalesTransaction> salesTransactionList) throws Exception {
		if(salesTransactionList.size() < 1) {
			throw new Exception("No data");
		}
		final String user = salesTransactionList.get(0).getApprover();
		SalesUser approverDetails = salesUserRepository.findByUsername(user);
		for(SalesTransaction eachRecord : salesTransactionList) {
			//fetch user id by invoking DB with username
		    eachRecord.setRequestedBy(eachRecord.getRequestedBy());
			eachRecord.setApprovedDate(new Date().toString());
		}
		salesTransactionRepository.saveAll(salesTransactionList);
		return retrieveRelationshipManagerTransactions(approverDetails.getUserEmailId());
	}

	
	@Override
	public List<SalesTransaction> updateTransaction(SalesTransaction salesTransaction) {
		salesTransactionRepository.save(salesTransaction);
		return salesTransactionRepository.findByRequestedByOrderByStatusAsc(salesTransaction.getRequestedBy());
	}
}
