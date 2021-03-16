package com.mindtree.SpringChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.SpringChallenge.entity.Bus;


@Repository
public interface BusRepository extends JpaRepository<Bus,Integer>{

	Bus findByBusName(String busName);

}
