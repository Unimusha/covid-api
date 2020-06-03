package com.covid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.entity.Dia;

@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {
}