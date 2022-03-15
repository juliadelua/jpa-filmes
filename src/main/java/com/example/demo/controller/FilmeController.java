package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Filme;
import com.example.demo.service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController implements ControllerInterface<Filme>{
	
	@Autowired
	private FilmeService service;

	@Override
	@GetMapping
	public ResponseEntity<List<Filme>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get (@PathVariable("id") Long id) {
		Filme _filme = service.findById(id);
		if (_filme != null)
			return ResponseEntity.ok(_filme);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@Override
	@PostMapping
	public ResponseEntity<Filme> post(@RequestBody Filme filme) throws URISyntaxException {
		service.create(filme);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filme.getId())
				.toUri();
		return ResponseEntity.created(location).body(filme);
	}
	
	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Filme filme) {
		if (service.update(filme)) {
			return ResponseEntity.ok(filme);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
}
