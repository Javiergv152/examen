package com.example.examenpractico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenpractico.model.Respuesta;

@Repository
public interface RespuestaRepository  extends JpaRepository<Respuesta, Integer>{

}
