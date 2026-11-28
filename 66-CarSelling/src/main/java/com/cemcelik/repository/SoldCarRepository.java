package com.cemcelik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cemcelik.model.SaledCar;

@Repository
public interface SoldCarRepository extends JpaRepository<SaledCar, Long> {

}
