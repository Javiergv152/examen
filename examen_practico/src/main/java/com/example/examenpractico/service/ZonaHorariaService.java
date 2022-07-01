package com.example.examenpractico.service;

import java.util.List;

import com.example.examenpractico.dto.PaisDTO;
import com.example.examenpractico.dto.ZonaHorariaDTO;

public interface ZonaHorariaService {

	public List<ZonaHorariaDTO> buscarPorPais(PaisDTO paisDTO);
	public ZonaHorariaDTO buscarPorId(Integer id);
}
