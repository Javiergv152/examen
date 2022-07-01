package com.example.examenpractico.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenpractico.model.Pregunta;
@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta,Integer> {

}
