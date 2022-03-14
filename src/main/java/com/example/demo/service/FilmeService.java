package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Filme;
import com.example.demo.repository.FilmeRepository;


@Service
public class FilmeService implements ServiceInterface<Filme>{
	
	@Autowired
	private FilmeRepository repository;

	public FilmeService() {
	}

	@Override
	public Filme create(Filme Filme) {
		repository.save(Filme);
		return Filme;
	}
	
	@Override
	public List<Filme> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Filme findById(Long id) {
		Optional<Filme> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
	@Override
	public boolean update(Filme Filme) {
		if (repository.existsById(Filme.getId())) {
			repository.save(Filme);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
