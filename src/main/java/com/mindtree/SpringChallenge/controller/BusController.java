package com.mindtree.SpringChallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.SpringChallenge.entity.Bus;
import com.mindtree.SpringChallenge.entity.Passenger;
import com.mindtree.SpringChallenge.exception.BusServiceException;
import com.mindtree.SpringChallenge.service.BusService;

@RestController
public class BusController {
	
	@Autowired
	private BusService service;
	
	@PostMapping("/addBus")
	public ResponseEntity<?> addBus(@RequestBody Bus bus) {
		String message;
		try {
			service.addBus(bus);
			message = "Bus added successfully";
			return new ResponseEntity(message,HttpStatus.CREATED);
		} catch (BusServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	 

	@PostMapping("/addPassenger/{busId}")
	public ResponseEntity<?> addPassenger(@RequestBody Passenger passenger,@PathVariable int busId) {
		String message;
		try {
			service.addPassenger(passenger,busId);
			message = "Passenger added successfully";
			return new ResponseEntity(message,HttpStatus.CREATED);
		} catch (BusServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	 
	@GetMapping("/getPassengersInBus/{busName}")
	public ResponseEntity<?> getPassengers(@PathVariable String busName) {
		String message;
		try {
			Bus passengersInBus = service.getPassengers(busName);
			return new ResponseEntity(passengersInBus,HttpStatus.OK);
		} catch (BusServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/updateAge/{passengerId}")
	public ResponseEntity<?> updateAgeById(@PathVariable int passengerId,@RequestBody int passengerAge) {
		String message;
		try {
			Passenger updatedPassenger = service.updateLocation(passengerId,passengerAge);
			return new ResponseEntity(updatedPassenger,HttpStatus.OK);
		} catch (BusServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deletePassenger/{passengerId}")
	public ResponseEntity<?> deletePassengerById(@PathVariable int passengerId) {
		String message;
		try {
			service.deletePassengerById(passengerId);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		} catch (BusServiceException e) {
			message = e.getMessage();
			return new ResponseEntity(message,HttpStatus.BAD_REQUEST);
		}
	}
}
