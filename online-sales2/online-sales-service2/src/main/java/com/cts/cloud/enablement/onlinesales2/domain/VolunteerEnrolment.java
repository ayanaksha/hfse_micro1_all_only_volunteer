package com.cts.cloud.enablement.onlinesales2.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author 547991
 *
 */
@Entity
@Table
public class VolunteerEnrolment implements Serializable {
	
	private static final long serialVersionUID = 2102917516769742591L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	
	@Column(name = "event_id")
	private Long eventID;
	
	@Column(name = "event_name")
	private String eventName;
	
	@Column(name = "beneficiary_name")
	private String beneficiaryName;
	
	@Column(name = "event_location")
	private String eventLocation;

	@Column(name = "event_date")
	private String eventDate;
		
	@Column(name = "emp_id")
	private Long empID;
	
	@Column(name = "status")
	private String status;
	
	/**
	 * Default constructor
	 */
	public VolunteerEnrolment() {
		super();
	}

	/**
	 * @param id
	 * @param amount
	 * @param projectionType
	 * @param projectionAmount
	 * @param status
	 * @param requestedBy
	 * @param approver
	 * @param createdDate
	 * @param approvedDate
	 * @param rmEmailId
	 * @param rowversion
	 */
	public VolunteerEnrolment(Long eventID, String eventName, 
			String beneficiaryName, String eventLocation, String eventDate, Long empID, 
			String status) {
		super();
		
		this.eventID = eventID;
		this.eventName = eventName;
		this.beneficiaryName = beneficiaryName;
		this.empID = empID;
		this.eventDate = eventDate;
		this.status = status;
		this.eventLocation = eventLocation;
		
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public Long getEmpID() {
		return empID;
	}

	public void setEmpID(Long empID) {
		this.empID = empID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}