package com.cts.cloud.enablement.onlinesales.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.cloud.enablement.onlinesales.domain.SalesTransaction;

/**
 * @author 547991
 *
 */
public interface SalesTransactionRepository extends JpaRepository<SalesTransaction, Long> {
	
	List<SalesTransaction> findByRequestedByOrderByStatusAsc(String id);
	
	List<SalesTransaction> findByRequestedByAndStatus(String id, String status);
	
	List<SalesTransaction> findByRequestedByIn(List<String> userList);
	
	List<SalesTransaction> findByRequestedBy(String requestedBy);
	
	List<SalesTransaction> findByRequestedByInAndStatus(List<String> userList, String status);
	
	SalesTransaction findById(int id);
}
