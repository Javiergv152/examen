package com.example.examenpractico.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examenpractico.model.Pais;
import com.example.examenpractico.model.ZonaHoraria;

@Repository
public interface ZonaHorariaRepository extends JpaRepository<ZonaHoraria, Integer> {

	List<ZonaHoraria> findByPais(Pais pais);
}
