package com.example.examenpractico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenpractico.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
