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

import com.covid.entity.Usuario;
import com.covid.service.UsuarioService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@ApiOperation(value = "Busca todos los usuarios")
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@ApiOperation(value = "Crea un usuario dando un array, Req.Mínimo: 'id_direccion', 'nombre', 'apellidos', 'email', 'contrasenia', 'genero', 'fecha_nacimiento', 'nacionalidad' y 'telefono' ")
	@PostMapping
	public ResponseEntity<Usuario> create(@Validated @RequestBody Usuario usuarioDto) throws ParseException {
		return ResponseEntity.ok(usuarioService.save(usuarioDto));
	}

	@ApiOperation(value = "Busca un usuario")
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.findById(id));
	}

	@ApiOperation(value = "Edita un usuario dando un array. Opciones: 'id_direccion' o 'nombre' o 'apellidos' o 'email' o 'contrasenia' o 'genero', 'fecha_nacimiento', 'nacionalidad' y 'telefono'")
	@PatchMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @Validated @RequestBody Usuario usuarioDto) {
		return ResponseEntity.ok(usuarioService.update(id, usuarioDto));
	}

	@ApiOperation(value = "Borra un usuario")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return ResponseEntity.ok("Usuario borrado correctamente");
	}

	@ApiOperation(value = "Comprueba si la contraseña del usuario es igual dando un array de 'nombre' y contraseña, devuelve true si es correcta la contraseña y false en caso de no coincidir la contraseña con el nombre dado")
	@PostMapping("/login")
	public ResponseEntity<String> login(@Validated @RequestBody Usuario usuarioDto) {
		return ResponseEntity.ok(usuarioService.login(usuarioDto));
	}

}
