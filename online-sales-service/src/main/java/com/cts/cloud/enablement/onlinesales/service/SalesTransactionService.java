package com.cts.cloud.enablement.onlinesales.service;

import java.util.List;

import com.cts.cloud.enablement.onlinesales.domain.SalesTransaction;

/**
 * @author 547991
 *
 */
public interface SalesTransactionService {
	
	List<SalesTransaction> retrieveTransactionsByUser(String username);
	
	List<SalesTransaction> retrieveRelationshipManagerTransactions(String username);

	List<SalesTransaction> createTransaction(SalesTransaction salesTransaction);
	
	List<SalesTransaction> updateTransaction(List<SalesTransaction> salesTransaction) throws Exception;
	
	List<SalesTransaction> updateTransaction(SalesTransaction salesTransaction);
}
