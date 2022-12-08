package com.ra.trainBooking.model;

import javax.persistence.*;

@Entity
@Table(name= "Reservation")
public class TrainData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "filter_date")
    private String filterDate;
	@Column(name = "to_destination")
	private String toDestination;
	@Column(name = "from_destination")
	private String fromDestination;
	@Column(name = "price")
	private Double price; 
	@Column(name = "train_name")
	private String TrainName;
	@Column(name = "time")
	private String time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getTrainName() {
		return TrainName;
	}
	public void setTrainName(String trainName) {
		TrainName = trainName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
