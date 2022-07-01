package com.example.examenpractico.service;

import java.util.List;

import com.example.examenpractico.dto.CiudadDTO;
import com.example.examenpractico.dto.PaisDTO;

public interface CiudadService {
	public List<CiudadDTO> consultarCiudades();
	public CiudadDTO consultarCiudadPorID(Integer id);
	public List<CiudadDTO> consultarCiudadesPorPais(PaisDTO paisDTO);

}
