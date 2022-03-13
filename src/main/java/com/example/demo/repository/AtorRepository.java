package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long>{
	
}
