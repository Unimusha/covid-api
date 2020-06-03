package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.entity.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}