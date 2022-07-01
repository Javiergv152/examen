package com.example.examenpractico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenpractico.model.Estudiante;
import com.example.examenpractico.model.EstudianteExamen;
import com.example.examenpractico.model.Examen;
@Repository
public interface EstudianteExamenRepository extends JpaRepository<EstudianteExamen, Integer> {
	public List<EstudianteExamen> findByEstudiante(Estudiante estudiante);
	public EstudianteExamen findByEstudianteAndExamen(Estudiante estudiante, Examen examen);
	public EstudianteExamen findByEstudianteAndId(Estudiante estudiante, Integer examenEstudianteId);

}
