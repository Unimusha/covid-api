package com.covid.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.entity.Covid;
import com.covid.repository.CovidRepository;

@Service
public class CovidService {
	@Autowired
	private CovidRepository covidRepository;

	public List<Covid> findAll() {
		return covidRepository.findAll();
	}

	public Covid findById(Long id) {
		return covidRepository.findById(id).get();
	}

	public Covid save(Covid covidDto) throws ParseException {
		return covidRepository.save(covidDto);
	}

	public Covid update(Long id, Covid covidDto) {
		Covid covidToUpdate = covidRepository.findById(id).get();

		if (covidDto.getIdUsuario() != null) {
			covidToUpdate.setIdUsuario(covidDto.getIdUsuario());
		}

		if (covidDto.getFechaAltaCovid() != null) {
			covidToUpdate.setFechaAltaCovid(covidDto.getFechaAltaCovid());
		}
		if (covidDto.getFechaDefuncion() != null) {
			covidToUpdate.setFechaDefuncion(covidDto.getFechaDefuncion());
		}
		if (covidDto.getFechaConfirmadoPositivo() != null) {
			covidToUpdate.setFechaConfirmadoPositivo(covidDto.getFechaConfirmadoPositivo());
		}

		return covidRepository.save(covidToUpdate);
	}

	public void deleteById(Long id) {
		covidRepository.deleteById(id);
	}

}
