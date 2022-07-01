package com.example.examenpractico.service;

import java.util.List;

import com.example.examenpractico.dto.CiudadDTO;
import com.example.examenpractico.dto.PaisDTO;
import com.example.examenpractico.dto.ZonaHorariaDTO;

public interface PaisService {

	public List<PaisDTO> consultarTodos();
	public List<CiudadDTO> consultarCiudadesPorPais(Integer paisId);
	public List<ZonaHorariaDTO> consultarZonaHorariaPorPais(Integer paisId);

}
