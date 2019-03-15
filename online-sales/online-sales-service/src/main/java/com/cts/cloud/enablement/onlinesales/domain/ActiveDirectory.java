package com.cts.cloud.enablement.onlinesales.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author 547991
 *
 */
@Entity
@Table
public class ActiveDirectory implements Serializable {

	private static final long serialVersionUID = 728806186124441033L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@GeneratedValue(strategy = GenerationType.TABLE)
		@Column(name = "id")
		private Long id;
		
		@Column(name = "empid", unique=true, nullable=false)
		private Long empid;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "empname")
		private String empname;
		
		@Column(name = "user_email_id", unique=true, nullable=false)
		private String userEmailId;
		
		@Column(name = "proj_id")
		private Long projId;
		
		@Column(name = "buid")
		private String buid;
		
		@Column(name = "role")
		private String role;
		
		
		/**
		 * Default constructor
		 */
		public ActiveDirectory() {
			super();
		}

		/**
		 * @param id
		 * @param username
		 * @param password
		 * @param userEmailId
		 * @param role
		 * @param phone
		 * @param location
		 */
		public ActiveDirectory(Long id, Long empid, String password, String empname, String userEmailId, Long projId, 
				String buid, String role) {
			super();
			this.id = id;
			this.empid = empid;
			this.password = password;
			this.empname = empname;
			this.userEmailId = userEmailId;
			this.projId = projId;
			this.buid = buid;
			this.role = role;
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getEmpid() {
			return empid;
		}

		public void setEmpid(Long empid) {
			this.empid = empid;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmpname() {
			return empname;
		}

		public void setEmpname(String empname) {
			this.empname = empname;
		}

		public String getUserEmailId() {
			return userEmailId;
		}

		public void setUserEmailId(String userEmailId) {
			this.userEmailId = userEmailId;
		}

		public Long getProjId() {
			return projId;
		}

		public void setProjId(Long projId) {
			this.projId = projId;
		}

		public String getBuid() {
			return buid;
		}

		public void setBuid(String buid) {
			this.buid = buid;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}


}