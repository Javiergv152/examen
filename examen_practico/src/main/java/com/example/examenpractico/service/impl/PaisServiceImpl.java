package com.example.examenpractico.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenpractico.dto.CiudadDTO;
import com.example.examenpractico.dto.PaisDTO;
import com.example.examenpractico.dto.ZonaHorariaDTO;
import com.example.examenpractico.errors.RegistroNoEncontradoException;
import com.example.examenpractico.model.Pais;
import com.example.examenpractico.repository.PaisRepository;
import com.example.examenpractico.service.CiudadService;
import com.example.examenpractico.service.PaisService;
import com.example.examenpractico.service.ZonaHorariaService;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private CiudadService ciudadService;
	@Autowired
	private ZonaHorariaService zonaHorariaService;

	@Override
	public List<PaisDTO> consultarTodos() {
		List<PaisDTO> paisDTOList = null;
		List<Pais> paisList = paisRepository.findAll();
		paisDTOList = new ArrayList<>();
		PaisDTO paisDTO = null;
		for (Pais pais : paisList) {
			paisDTO = new PaisDTO(pais.getId(), pais.getPais(), pais.getContinente());
			paisDTOList.add(paisDTO);
		}
		return paisDTOList;
	}

	private PaisDTO consultarPais(Integer paisId) {
		Pais pais = null;		
		try {
			pais = paisRepository.findById(paisId).get();
		} catch (NoSuchElementException e) {
			throw new RegistroNoEncontradoException("No se encontró el registro Pais");
		}
		PaisDTO paisDTO = new PaisDTO(pais.getId(), pais.getPais(), pais.getContinente());
		return paisDTO;
	}
	
	@Override
	public List<CiudadDTO> consultarCiudadesPorPais(Integer paisId) {
		PaisDTO paisDTO = consultarPais(paisId);
		return ciudadService.consultarCiudadesPorPais(paisDTO);
	}

	@Override
	public List<ZonaHorariaDTO> consultarZonaHorariaPorPais(Integer paisId) {
		PaisDTO paisDTO =  consultarPais(paisId);
		return zonaHorariaService.buscarPorPais(paisDTO);
	}

}
