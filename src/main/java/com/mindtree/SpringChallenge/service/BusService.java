package com.mindtree.SpringChallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.SpringChallenge.entity.Bus;
import com.mindtree.SpringChallenge.entity.Passenger;
import com.mindtree.SpringChallenge.exception.BusServiceException;
import com.mindtree.SpringChallenge.repository.BusRepository;
import com.mindtree.SpringChallenge.repository.PassengerRepository;


@Service
public class BusService {
	
	@Autowired
	private BusRepository busrepo;
	@Autowired
	private PassengerRepository passengerrepo;

	public Bus addBus(Bus bus) throws BusServiceException{
		int Id = bus.getBusId();
		Bus busPresent = null;
		busPresent = busrepo.findById(Id).orElse(null);
		if(busPresent == null) {
			return busrepo.save(bus);
		}
		else {
			throw new BusServiceException("BusId is already added in the database");
		}
	}
	
	
	public Passenger addPassenger(Passenger passenger, int busId) throws BusServiceException {
		Bus busPresent = busrepo.findById(busId).orElse(null);
		int Id = passenger.getPassengerId();
		Passenger passengerPresent = passengerrepo.findById(Id).orElse(null);
		if(passengerPresent == null) {
			passenger.setBus(busPresent);
			return passengerrepo.save(passenger);
		}
		else {
			throw new BusServiceException("Passenger Id is already added in the database");
		}
	}

	public Bus getPassengers(String busName) throws BusServiceException {
		Bus bus = busrepo.findByBusName(busName);
		if(bus != null) {
			return bus;
		}
		else {
			throw new BusServiceException("No such Bus is present in the database");
		}
	}

	public Passenger updateLocation(int passengerId, int passengerAge) throws BusServiceException {
		Passenger passengerPresent = passengerrepo.findById(passengerId).orElse(null);
		if(passengerPresent != null) {
			passengerPresent.setPassengerAge(passengerAge);
			return passengerrepo.save(passengerPresent);
		}
		else {
			throw new BusServiceException("No such passsenger is present in the database to update age");
		}
	}

	public String deletePassengerById(int passengerId) throws BusServiceException {
		Passenger passengerPresent = passengerrepo.findById(passengerId).orElse(null);
		if(passengerPresent != null) {
			passengerrepo.deleteById(passengerId);
			return "Passenger details deleted successfully";
		}
		else {
			throw new BusServiceException("No such passenger is available in the database");
		}
	}

}
