package com.covid.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.entity.Direccion;
import com.covid.repository.DireccionRepository;

@Service
public class DireccionService {
	@Autowired
	private DireccionRepository direccionRepository;

	public List<Direccion> findAll() {
		return direccionRepository.findAll();
	}

	public Direccion findById(Long id) {
		return direccionRepository.findById(id).get();
	}

	public Direccion save(Direccion direccionDto) throws ParseException {

		return direccionRepository.save(direccionDto);
	}

	public Direccion update(Long id, Direccion direccionDto) {
		Direccion direccionToUpdate = direccionRepository.findById(id).get();

		if (direccionDto.getPais() != null) {
			direccionToUpdate.setPais(direccionDto.getPais());
		}
		if (direccionDto.getRegion() != null) {
			direccionToUpdate.setRegion(direccionDto.getRegion());
		}
		if (direccionDto.getRegion() != null) {
			direccionToUpdate.setRegion(direccionDto.getRegion());
		}
		if (direccionDto.getProvincia() != null) {
			direccionToUpdate.setProvincia(direccionDto.getProvincia());
		}
		if (direccionDto.getLocalidad() != null) {
			direccionToUpdate.setLocalidad(direccionDto.getLocalidad());
		}
		if (direccionDto.getDireccion() != null) {
			direccionToUpdate.setDireccion(direccionDto.getDireccion());
		}
		if (direccionDto.getCodigoPostal() != null) {
			direccionToUpdate.setCodigoPostal(direccionDto.getCodigoPostal());
		}

		return direccionRepository.save(direccionToUpdate);
	}

	public void deleteById(Long id) {
		direccionRepository.deleteById(id);
	}

}
