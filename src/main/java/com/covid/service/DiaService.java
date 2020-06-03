package com.covid.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.entity.Dia;
import com.covid.repository.DiaRepository;

@Service
public class DiaService {
	@Autowired
	private DiaRepository diaRepository;

	public List<Dia> findAll() {
		return diaRepository.findAll();
	}

	public Dia findById(Long id) {
		return diaRepository.findById(id).get();
	}

	public Dia save(Dia diaDto) throws ParseException {
		return diaRepository.save(diaDto);
	}

	public Dia update(Long id, Dia diaDto) {
		Dia diaToUpdate = diaRepository.findById(id).get();

		if (diaDto.getIdCovid() != null) {
			diaToUpdate.setIdCovid(diaDto.getIdCovid());
		}

		if (diaDto.getSintoma1() != null) {
			diaToUpdate.setSintoma1(diaDto.getSintoma1());
		}
		if (diaDto.getSintoma2() != null) {
			diaToUpdate.setSintoma2(diaDto.getSintoma2());
		}
		if (diaDto.getTratamiento() != null) {
			diaToUpdate.setTratamiento(diaDto.getTratamiento());
		}
		if (diaDto.getConfinamientoRoto() != null) {
			diaToUpdate.setConfinamientoRoto(diaDto.getConfinamientoRoto());
		}
		if (diaDto.getEstadoAnimo() != null) {
			diaToUpdate.setEstadoAnimo(diaDto.getEstadoAnimo());
		}
		if (diaDto.getNota() != null) {
			diaToUpdate.setNota(diaDto.getNota());
		}

		return diaRepository.save(diaToUpdate);
	}

	public void deleteById(Long id) {
		diaRepository.deleteById(id);
	}

}
