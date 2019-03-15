package com.cts.cloud.enablement.onlinesales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.cloud.enablement.onlinesales.domain.ActiveDirectory;

/**
 * @author 547991
 *
 */
public interface ActiveDirectoryRepository extends JpaRepository<ActiveDirectory, Long> {
	
	ActiveDirectoryRepository findByEmpID(Long empid);
	
	ActiveDirectoryRepository findByUserEmailId(String userEmailId);
	
	ActiveDirectoryRepository findByEmpIDAndPassword(Long EmpID, String password);
	
	ActiveDirectoryRepository findById(long id);
	
	List<ActiveDirectoryRepository> findByRole(String role);
	
	List<ActiveDirectoryRepository> findByProjID(Long projID);
	
}