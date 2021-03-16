package com.mindtree.SpringChallenge.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "Buses")
public class Bus {
	
	@Id
	private int busId;
	private String busName;
	private String busType;
	
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
	private List<Passenger> passengers;

	public Bus() {
		super();
	}

	public Bus(int busId, String busName, String busType) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.busType = busType;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}
	
	@JsonManagedReference
	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	
	
}
