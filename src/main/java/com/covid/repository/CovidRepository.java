package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.entity.Covid;

@Repository
public interface CovidRepository extends JpaRepository<Covid, Long> {

}