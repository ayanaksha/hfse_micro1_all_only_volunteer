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
public class SalesUser implements Serializable {

	private static final long serialVersionUID = 728806186124441033L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@GeneratedValue(strategy = GenerationType.TABLE)
		@Column(name = "id")
		private Long id;
		
		@Column(name = "username")
		private String username;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "user_email_id", unique=true, nullable=false)
		private String userEmailId;
		
		@Column(name = "role")
		private String role;
		
		@Column(name = "phone")
		private String phone;
		
		@Column(name = "location")
		private String location;
		
		/**
		 * Default constructor
		 */
		public SalesUser() {
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
		public SalesUser(Long id, String username, String password, String userEmailId, String role, String phone,
				String location) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.userEmailId = userEmailId;
			this.role = role;
			this.phone = phone;
			this.location = location;
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}

		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}

		/**
		 * @return the role
		 */
		public String getRole() {
			return role;
		}

		/**
		 * @param role the role to set
		 */
		public void setRole(String role) {
			this.role = role;
		}

		/**
		 * @return the email
		 */
		public String getUserEmailId() {
			return userEmailId;
		}

		/**
		 * @param email the email to set
		 */
		public void setUserEmailId(String userEmailId) {
			this.userEmailId = userEmailId;
		}

		/**
		 * @return the phone
		 */
		public String getPhone() {
			return phone;
		}

		/**
		 * @param phone the phone to set
		 */
		public void setPhone(String phone) {
			this.phone = phone;
		}

		/**
		 * @return the location
		 */
		public String getLocation() {
			return location;
		}

		/**
		 * @param location the location to set
		 */
		public void setLocation(String location) {
			this.location = location;
		}

		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
}
