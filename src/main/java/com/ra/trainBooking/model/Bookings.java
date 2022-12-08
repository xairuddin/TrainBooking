package com.ra.trainBooking.model;

import javax.persistence.*;

@Entity
@Table(name = "Bookings")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "no_of_persons")
	private int noOfPersons ;
	@Column(name = "total_calculated")
	private Double totalCalculated ;
	@Column(name = "filter_date")
	private String filterDate;
	@Column(name = "to_destination")
	private String toDestination;
	@Column(name = "from_destination")
	private String fromDestination;
	@Column(name = "train_name")
	private String TrainName;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "time")
	private String time;
	@Column(name = "file_name")
	private String fileName;
	@Column(name = "trip_status")
	private boolean tripStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(int noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public Double getTotalCalculated() {
		return totalCalculated;
	}

	public void setTotalCalculated(Double totalCalculated) {
		this.totalCalculated = totalCalculated;
	}

	public String getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(String filterDate) {
		this.filterDate = filterDate;
	}

	public String getToDestination() {
		return toDestination;
	}

	public void setToDestination(String toDestination) {
		this.toDestination = toDestination;
	}

	public String getFromDestination() {
		return fromDestination;
	}

	public void setFromDestination(String fromDestination) {
		this.fromDestination = fromDestination;
	}

	public String getTrainName() {
		return TrainName;
	}

	public void setTrainName(String trainName) {
		TrainName = trainName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public boolean isTripStatus() {
		return tripStatus;
	}
	public void setTripStatus(boolean tripStatus) {
		this.tripStatus = tripStatus;
	}
}
