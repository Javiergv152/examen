package com.example.examenpractico.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenpractico.model.RespuestaEstudiante;

@Repository
public interface RespuestaEstudianteRepository extends JpaRepository<RespuestaEstudiante, Integer> {

}
