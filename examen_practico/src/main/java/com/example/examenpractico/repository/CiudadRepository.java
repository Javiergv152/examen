package com.example.examenpractico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenpractico.model.Ciudad;
import com.example.examenpractico.model.Pais;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
	List<Ciudad> findByPais(Pais pais);
}
