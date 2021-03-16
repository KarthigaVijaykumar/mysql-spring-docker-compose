package com.mindtree.SpringChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.SpringChallenge.entity.Passenger;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer>{

}
