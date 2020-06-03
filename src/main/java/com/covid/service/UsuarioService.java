package com.covid.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.covid.entity.Usuario;
import com.covid.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public Usuario save(Usuario usuarioDto) throws ParseException {

		usuarioDto.setContrasenia(encriptarContrasenia(usuarioDto.getContrasenia()));
		return usuarioRepository.save(usuarioDto);
	}

	public Usuario update(Long id, Usuario usuarioDto) {
		Usuario usuarioToUpdate = usuarioRepository.findById(id).get();

		if (usuarioDto.getIdDireccion() != null) {
			usuarioToUpdate.setIdDireccion(usuarioDto.getIdDireccion());
		}

		if (usuarioDto.getNombre() != null) {
			usuarioToUpdate.setNombre(usuarioDto.getNombre());
		}
		if (usuarioDto.getApellidos() != null) {
			usuarioToUpdate.setApellidos(usuarioDto.getApellidos());
		}
		if (usuarioDto.getEmail() != null) {
			usuarioToUpdate.setEmail(usuarioDto.getEmail());
		}
		if (usuarioDto.getContrasenia() != null) {
			usuarioToUpdate.setContrasenia(encriptarContrasenia(usuarioDto.getContrasenia()));
		}
		if (usuarioDto.getGenero() != null) {
			usuarioToUpdate.setGenero(usuarioDto.getGenero());
		}
		if (usuarioDto.getFechaNacimiento() != null) {
			usuarioToUpdate.setFechaNacimiento(usuarioDto.getFechaNacimiento());
		}
		if (usuarioDto.getNacionalidad() != null) {
			usuarioToUpdate.setNacionalidad(usuarioDto.getNacionalidad());
		}
		if (usuarioDto.getTelefono() != null) {
			usuarioToUpdate.setTelefono(usuarioDto.getTelefono());
		}

		return usuarioRepository.save(usuarioToUpdate);
	}

	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

	public String login(Usuario usuarioDto) {
		Usuario usuarioToCheck = usuarioRepository.findByNombre(usuarioDto.getNombre());
		if (usuarioToCheck != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if (passwordEncoder.matches(usuarioDto.getContrasenia(), usuarioToCheck.getContrasenia())) {
				return "true";
			} else {
				return "false";
			}
		} else {
			return "false";
		}
	}

	public String encriptarContrasenia(String contrasenia) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(contrasenia);
	}

}
