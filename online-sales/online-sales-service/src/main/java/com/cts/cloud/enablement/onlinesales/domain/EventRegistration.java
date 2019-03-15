package com.cts.cloud.enablement.onlinesales.domain;

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
public class EventRegistration implements Serializable {
	
	private static final long serialVersionUID = 2102917516769742591L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "Reg_id")
	private Long id;
	
	@Column(name = "event_id")
	private Long eventID;
	
	@Column(name = "emp_id")
	private Long empID;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "event_location")
	private String eventLocation;
	
	@Column(name = "beneficiary_name")
	private String beneficiaryName;

	@Column(name = "council_name")
	private String councilName;
	
	@Column(name = "event_name")
	private String eventName;
	
	@Column(name = "event_desc")
	private String eventDesc;

	@Column(name = "event_date")
	private String eventDate;
	
	@Column(name = "buid")
	private Long buid;
	
	@Column(name = "emp_proj_id")
	private Long empProjId;
		
	@Column(name = "status")
	private String status;
	
	
	/**
	 * Default constructor
	 */
	public EventRegistration() {
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
	public EventRegistration(Long id, Long eventID,  
			Long empID, String empName, String eventLocation, String beneficiaryName,
			String councilName, String eventName, String eventDesc,
			String eventDate, Long buid, Long empProjId, String status) {
		super();
		this.id = id;
		this.eventID = eventID;
		this.empID = empID;
		this.empName = empName;
		this.eventLocation = eventLocation;
		this.beneficiaryName = beneficiaryName;
		this.councilName = councilName;
		this.eventName = eventName;
		this.eventDesc = eventDesc;
		this.eventDate = eventDate;
		this.buid = buid;
		this.empProjId = empProjId;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventID() {
		return eventID;
	}

	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

	public Long getEmpID() {
		return empID;
	}

	public void setEmpID(Long empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDesc() {
		return eventDesc;
	}

	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public Long getBuid() {
		return buid;
	}

	public void setBuid(Long buid) {
		this.buid = buid;
	}

	public Long getEmpProjId() {
		return empProjId;
	}

	public void setEmpProjId(Long empProjId) {
		this.empProjId = empProjId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}