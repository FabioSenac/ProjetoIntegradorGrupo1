package com.bd.source;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bd.model.Usuario;
import com.bd.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuario")
public class UsuarioResouce {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> list() {
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> findById(@PathVariable long id) {
		return usuarioRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario save = usuarioRepository.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		usuarioRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable long id, @RequestBody Usuario usuario) {
		Optional<Usuario> usuarioBanco = usuarioRepository.findById(id);
		BeanUtils.copyProperties(usuario, usuarioBanco.get(), "id");
		usuarioRepository.save(usuarioBanco.get());
		return ResponseEntity.ok(usuario);
	}
}
