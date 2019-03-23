package com.cts.cloud.enablement.onlinesales.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.cloud.enablement.onlinesales.domain.ActiveDirectory;

/**
 * @author 547991
 *
 */
public interface ActiveDirectoryRepository extends JpaRepository<ActiveDirectory, Long> {
	
	ActiveDirectory findByEmpid(Long empid);
	
	ActiveDirectory findByUserEmailId(String userEmailId);
	
	ActiveDirectory findByEmpidAndPassword(Long EmpID, String password);
	
	ActiveDirectory findById(long id);
	
	List<ActiveDirectory> findByRole(String role);
	
	List<ActiveDirectory> findByProjId(Long projID);
	
}