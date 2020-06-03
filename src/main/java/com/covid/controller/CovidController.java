package com.covid.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.entity.Covid;
import com.covid.service.CovidService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/covid")
@CrossOrigin(origins = "*")

public class CovidController {

	@Autowired
	CovidService covidService;

	@ApiOperation(value = "Busca todos los covid")
	@GetMapping
	public ResponseEntity<List<Covid>> findAll() {
		return ResponseEntity.ok(covidService.findAll());
	}

	@ApiOperation(value = "Crea una mesa dando un array, Req.Mínimo: 'id_usuario'")
	@PostMapping
	public ResponseEntity<Covid> create(@Validated @RequestBody Covid covidDto) throws ParseException {
		return ResponseEntity.ok(covidService.save(covidDto));
	}

	@ApiOperation(value = "Busca un covid")
	@GetMapping("/{id}")
	public ResponseEntity<Covid> findById(@PathVariable Long id) {
		return ResponseEntity.ok(covidService.findById(id));
	}

	@ApiOperation(value = "Edita un covid dando un array, Opciones: 'id_usuario' o 'fecha_alta_covid' o 'fecha_defuncion' o 'fecha_confirmado_positivo'")
	@PatchMapping("/{id}")
	public ResponseEntity<Covid> update(@PathVariable Long id, @Validated @RequestBody Covid covidDto)
			throws ParseException {
		return ResponseEntity.ok(covidService.update(id, covidDto));
	}

	@ApiOperation(value = "Borra un covid")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		covidService.deleteById(id);
		return ResponseEntity.ok("Covid borrado correctamente");
	}

}
