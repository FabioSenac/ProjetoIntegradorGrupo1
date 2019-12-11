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

import com.bd.model.Posto;
import com.bd.repository.PostoRepository;

@RestController
@RequestMapping("/posto")
public class PostoResouce {

	@Autowired
	private PostoRepository postoRepository;
	
	@GetMapping
	public List<Posto> list() {
		return postoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Posto> findById(@PathVariable long id) {
		return postoRepository.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Posto> create(@RequestBody Posto posto, HttpServletResponse response) {
		Posto save = postoRepository.save(posto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		postoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Posto> update(@PathVariable long id, @RequestBody Posto posto) {
		Optional<Posto> postoBanco = postoRepository.findById(id);
		BeanUtils.copyProperties(posto, postoBanco.get(), "id");
		postoRepository.save(postoBanco.get());
		return ResponseEntity.ok(posto);
	}
}
