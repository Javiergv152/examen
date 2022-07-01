package com.example.examenpractico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenpractico.model.Examen;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {
	public Examen findByNombreExamen(String nombre);

}
