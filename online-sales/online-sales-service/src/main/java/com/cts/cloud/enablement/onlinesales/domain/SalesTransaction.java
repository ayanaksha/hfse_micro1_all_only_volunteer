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
public class SalesTransaction implements Serializable {
	
	private static final long serialVersionUID = 2102917516769742591L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "event_type")
	private String eventType;
	
	@Column(name = "event_time")
	private String eventTime;
	
	@Column(name = "event_location")
	private String eventLocation;

	@Column(name = "status")
	private String status;
	
	@Column(name = "requested_by")
	private String requestedBy;
	
	@Column(name = "approver")
	private String approver;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "rm_email_id")
	private String rmEmailId;
	
	/**
	 * Default constructor
	 */
	public SalesTransaction() {
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
	public SalesTransaction(Long id, String eventType, String eventTime, String eventLocation,
			String status, String requestedBy, String createdDate, 
			String rmEmailId, String approver) {
		super();
		this.id = id;
		this.eventType = eventType;
		this.eventTime = eventTime;
		this.eventLocation = eventLocation;
		this.status = status;
		this.requestedBy = requestedBy;
		this.approver = approver;
		this.createdDate = createdDate;
		this.rmEmailId = rmEmailId;
	}

	/**
	 * @return the rmEmailId
	 */
	public String getRmEmailId() {
		return rmEmailId;
	}

	/**
	 * @param rmEmailId the rmEmailId to set
	 */
	public void setRmEmailId(String rmEmailId) {
		this.rmEmailId = rmEmailId;
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
	
	/**
	 * @return the projection_type
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * @param projection_type the projection_type to set
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * 	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the requested_by
	 */
	public String getRequestedBy() {
		return requestedBy;
	}

	/**
	 * @param requested_by the requested_by to set
	 */
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	
	public String getApprover() {
		return approver;
	}

	/**
	 * @param requested_by the requested_by to set
	 */
	public void setApprover(String approver) {
		this.approver = approver;
	}

		/**
	 * @return the created_date
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param created_date the created_date to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the approved_date
	 */
	public String getEventTime() {
		return eventTime;
	}

	/**
	 * @param approved_date the approved_date to set
	 */
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	
	/**
	 * @return the approved_date
	 */
	public String getEventLocation() {
		return eventLocation;
	}

	/**
	 * @param approved_date the approved_date to set
	 */
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
}
