package com.example.examenpractico.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenpractico.dto.CiudadDTO;
import com.example.examenpractico.dto.PaisDTO;
import com.example.examenpractico.errors.RegistroNoEncontradoException;
import com.example.examenpractico.model.Ciudad;
import com.example.examenpractico.model.Pais;
import com.example.examenpractico.repository.CiudadRepository;
import com.example.examenpractico.service.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;

	@Override
	public List<CiudadDTO> consultarCiudades() {
		List<Ciudad> ciudadesModelo = ciudadRepository.findAll();
		if (ciudadesModelo == null || ciudadesModelo.isEmpty()) {
			throw new RegistroNoEncontradoException("No se encontrarón registros");
		}
		return convertirListaRespuesta(ciudadesModelo);
	}

	private List<CiudadDTO> convertirListaRespuesta(List<Ciudad> ciudadesModelo) {
		List<CiudadDTO> ciudadesDTO = new ArrayList<>();
		for (Ciudad ciudadModelo : ciudadesModelo) {
			CiudadDTO ciudadDTO = new CiudadDTO(ciudadModelo.getId(), ciudadModelo.getCiudad(),
					ciudadModelo.getPais().getPais(), ciudadModelo.getPais().getId());
			ciudadesDTO.add(ciudadDTO);
		}
		return ciudadesDTO;

	}

	@Override
	public CiudadDTO consultarCiudadPorID(Integer id) {
		CiudadDTO ciudadDTO = null;
		try {
			Ciudad Ciudad = ciudadRepository.findById(id).get();
			ciudadDTO = new CiudadDTO(Ciudad.getId(), Ciudad.getCiudad(), Ciudad.getPais().getPais(),
					Ciudad.getPais().getId());
		} catch (NoSuchElementException e) {
			throw new RegistroNoEncontradoException("No se encontró el registro");
		}

		return ciudadDTO;
	}

	@Override
	public List<CiudadDTO> consultarCiudadesPorPais(PaisDTO paisDTO) {
		Pais pais = new Pais();
		pais.setId(paisDTO.getId());
		List<Ciudad> ciudadList = ciudadRepository.findByPais(pais);
		if (ciudadList == null || ciudadList.isEmpty()) {
			throw new RegistroNoEncontradoException("No se encontrarón registros");
		}
		return convertirListaRespuesta(ciudadList);
	}

}
