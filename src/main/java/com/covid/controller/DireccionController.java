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

import com.covid.entity.Direccion;
import com.covid.service.DireccionService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/direcciones")
@CrossOrigin(origins = "*")

public class DireccionController {

	@Autowired
	DireccionService direccionService;

	@ApiOperation(value = "Busca todas las direcciones")
	@GetMapping
	public ResponseEntity<List<Direccion>> findAll() {
		return ResponseEntity.ok(direccionService.findAll());
	}

	@ApiOperation(value = "Crea una dirección dando un array, Req.Mínimo: 'pais', 'region', 'provincia', 'localidad', 'direccion' y 'codigo_postal' ")
	@PostMapping
	public ResponseEntity<Direccion> create(@Validated @RequestBody Direccion direccionDto) throws ParseException {
		return ResponseEntity.ok(direccionService.save(direccionDto));
	}

	@ApiOperation(value = "Busca una dirección")
	@GetMapping("/{id}")
	public ResponseEntity<Direccion> findById(@PathVariable Long id) {
		return ResponseEntity.ok(direccionService.findById(id));
	}

	@ApiOperation(value = "Edita una dirección dando un array, Opciones: 'pais' o 'region' o 'provincia' o 'localidad' o 'direccion' o 'codigo_postal'")
	@PatchMapping("/{id}")
	public ResponseEntity<Direccion> update(@PathVariable Long id, @Validated @RequestBody Direccion direccionDto)
			throws ParseException {
		return ResponseEntity.ok(direccionService.update(id, direccionDto));
	}

	@ApiOperation(value = "Borra una dirección")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		direccionService.deleteById(id);
		return ResponseEntity.ok("Dirección borrada correctamente");
	}

}
