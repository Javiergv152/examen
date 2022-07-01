package com.example.examenpractico.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenpractico.dto.PaisDTO;
import com.example.examenpractico.dto.ZonaHorariaDTO;
import com.example.examenpractico.errors.RegistroNoEncontradoException;
import com.example.examenpractico.model.Pais;
import com.example.examenpractico.model.ZonaHoraria;
import com.example.examenpractico.repository.ZonaHorariaRepository;
import com.example.examenpractico.service.ZonaHorariaService;

@Service
public class ZonaHorariaServiceImpl implements ZonaHorariaService {
	@Autowired
	private ZonaHorariaRepository zonaHorariaRepository;

	@Override
	public List<ZonaHorariaDTO> buscarPorPais(PaisDTO paisDTO) {
		ZonaHorariaDTO zonaHorariaDTO = null;
		List<ZonaHorariaDTO> zonaHorariaDTOList = null;
		Pais pais = new Pais();
		pais.setId(paisDTO.getId());
		try {
			List<ZonaHoraria> zonaHorariaList = zonaHorariaRepository.findByPais(pais);
			if (zonaHorariaList == null || zonaHorariaList.isEmpty()) {
				throw new RegistroNoEncontradoException("No se encontró el registro");
			}
			zonaHorariaDTOList = new ArrayList<>();
			for (ZonaHoraria zonaHoraria : zonaHorariaList) {
				zonaHorariaDTO = new ZonaHorariaDTO(zonaHoraria.getId(), zonaHoraria.getUtc(),
						zonaHoraria.getZonaHoraria(), zonaHoraria.getPais().getPais(), zonaHoraria.getPais().getId());
				zonaHorariaDTOList.add(zonaHorariaDTO);
			}

		} catch (NoSuchElementException e) {
			throw new RegistroNoEncontradoException("No se encontró el registro Zona horaria");
		}

		return zonaHorariaDTOList;

	}

	@Override
	public ZonaHorariaDTO buscarPorId(Integer id) {
		ZonaHoraria zonaHoraria = null;
		ZonaHorariaDTO zonaHorariaDTO = null;
		try {
			zonaHoraria = zonaHorariaRepository.findById(id).get();
			zonaHorariaDTO = new ZonaHorariaDTO(id, zonaHoraria.getUtc(), zonaHoraria.getZonaHoraria(), zonaHoraria.getPais().getPais(), zonaHoraria.getPais().getId());
		} catch (NoSuchElementException e) {
			throw new RegistroNoEncontradoException("No se encontró el registro Pais");
		}
		return zonaHorariaDTO;
	}

}
