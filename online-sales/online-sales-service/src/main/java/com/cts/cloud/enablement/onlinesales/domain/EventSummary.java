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
public class EventSummary implements Serializable {

	private static final long serialVersionUID = 728806186124441033L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//@GeneratedValue(strategy = GenerationType.TABLE)
		@Column(name = "id")
		private Long eventID;

		@Column(name = "event_date")
		private String eventDate;
		
		@Column(name = "location")
		private String location;

		@Column(name = "venue_address")
		private String venueAddress;

		@Column(name = "council")
		private String council;
		
		@Column(name = "category")
		private String category;
		
		@Column(name = "event_name")
		private String eventName;
		
		@Column(name = "event_desc")
		private String eventDesc;
		
		@Column(name = "activity_type")
		private String activityType;
		
		@Column(name = "status")
		private String status;
	
		@Column(name = "poc_id")
		private Long pocID;
		
		@Column(name = "poc_name")
		private String pocName;
		
		@Column(name = "start_time")
		private String startTime;
		
		@Column(name = "end_time")
		private String endTime;
		
		@Column(name = "volunteers_req")
		private String volunteersReq;
		
		@Column(name = "boarding_points")
		private String boardingPoints;
		
		@Column(name = "drop_points")
		private String dropPoints;
		
		@Column(name = "lives_touched")
		private String livesTouched;
		/**
		 * Default constructor
		 */
		public EventSummary() {
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
		public EventSummary(Long eventID, String eventDate, String location, String venueAddress,
				String council, String category, String eventName, String eventDesc, String activityType
				String status, Long pocID, String pocName, String startTime, String endTime
				String volunteersReq, String boardingPoints, String dropPoints, String livesTouched) {
			super();
			this.eventID = eventID;
			this.eventDate = eventDate;
			this.location = location;
			this.venueAddress = venueAddress;
			this.council = council;
			this.category = category;
			this.eventName = eventName;
			this.eventDesc = eventDesc;
			this.activityType = activityType;
			this.status = status;
			this.pocID = pocID;
			this.pocName = pocName;
			this.startTime = startTime;
			this.endTime = endTime;
			this.volunteersReq = volunteersReq;
			this.boardingPoints = boardingPoints;
			this.dropPoints = dropPoints;
			this.livesTouched = livesTouched;

		}

		public Long getEventID() {
			return eventID;
		}

		public void setEventID(Long eventID) {
			this.eventID = eventID;
		}

		public String getEventDate() {
			return eventDate;
		}

		public void setEventDate(String eventDate) {
			this.eventDate = eventDate;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getVenueAddress() {
			return venueAddress;
		}

		public void setVenueAddress(String venueAddress) {
			this.venueAddress = venueAddress;
		}

		public String getCouncil() {
			return council;
		}

		public void setCouncil(String council) {
			this.council = council;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
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

		public String getActivityType() {
			return activityType;
		}

		public void setActivityType(String activityType) {
			this.activityType = activityType;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Long getPocID() {
			return pocID;
		}

		public void setPocID(Long pocID) {
			this.pocID = pocID;
		}

		public String getPocName() {
			return pocName;
		}

		public void setPocName(String pocName) {
			this.pocName = pocName;
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}

		public String getVolunteersReq() {
			return volunteersReq;
		}

		public void setVolunteersReq(String volunteersReq) {
			this.volunteersReq = volunteersReq;
		}

		public String getBoardingPoints() {
			return boardingPoints;
		}

		public void setBoardingPoints(String boardingPoints) {
			this.boardingPoints = boardingPoints;
		}

		public String getDropPoints() {
			return dropPoints;
		}

		public void setDropPoints(String dropPoints) {
			this.dropPoints = dropPoints;
		}

		public String getLivesTouched() {
			return livesTouched;
		}

		public void setLivesTouched(String livesTouched) {
			this.livesTouched = livesTouched;
		}

		

}