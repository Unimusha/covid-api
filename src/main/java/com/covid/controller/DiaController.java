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

import com.covid.entity.Dia;
import com.covid.service.DiaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/dias")
@CrossOrigin(origins = "*")

public class DiaController {

	@Autowired
	DiaService diaService;

	@ApiOperation(value = "Busca todos los días")
	@GetMapping
	public ResponseEntity<List<Dia>> findAll() {
		return ResponseEntity.ok(diaService.findAll());
	}

	@ApiOperation(value = "Crea un día dando un array, Req.Mínimo: 'id_covid', 'sintoma1', 'sintoma2', 'tratamiento', 'confinamiento_roto', 'estado_animo' y 'nota'")
	@PostMapping
	public ResponseEntity<Dia> create(@Validated @RequestBody Dia diaDto) throws ParseException {
		return ResponseEntity.ok(diaService.save(diaDto));
	}

	@ApiOperation(value = "Busca un día")
	@GetMapping("/{id}")
	public ResponseEntity<Dia> findById(@PathVariable Long id) {
		return ResponseEntity.ok(diaService.findById(id));
	}

	@ApiOperation(value = "Edita un día dando un array, Opciones: 'id_covid' o 'sintoma1' o 'sintoma2' o 'tratamiento' o 'confinamiento_roto' o 'estado_animo' o 'nota'")
	@PatchMapping("/{id}")
	public ResponseEntity<Dia> update(@PathVariable Long id, @Validated @RequestBody Dia diaDto) throws ParseException {
		return ResponseEntity.ok(diaService.update(id, (diaDto)));
	}

	@ApiOperation(value = "Borra un día")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		diaService.deleteById(id);
		return ResponseEntity.ok("Día borrado correctamente");
	}

}
