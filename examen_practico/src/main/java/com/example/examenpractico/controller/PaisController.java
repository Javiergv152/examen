package com.example.examenpractico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenpractico.dto.CiudadDTO;
import com.example.examenpractico.dto.PaisDTO;
import com.example.examenpractico.dto.ZonaHorariaDTO;
import com.example.examenpractico.service.PaisService;

@RestController
public class PaisController {
	@Autowired
	private PaisService paisService;

	@RequestMapping(value = "/pais", method = RequestMethod.GET)
	public ResponseEntity<List<PaisDTO>> getpaises() {
		List<PaisDTO> paisList = paisService.consultarTodos();
		return new ResponseEntity<>(paisList, HttpStatus.OK);
	}

	@RequestMapping(value = "/pais/{idPais}/ciudad", method = RequestMethod.GET)
	public ResponseEntity<List<CiudadDTO>> getCiudadesPorPais(@PathVariable(required = true) Integer idPais) {
		List<CiudadDTO> ciudadList = paisService.consultarCiudadesPorPais(idPais);
		return new ResponseEntity<>(ciudadList, HttpStatus.OK);
	}

	@RequestMapping(value = "/pais/{idPais}/zonahoraria", method = RequestMethod.GET)
	public ResponseEntity<List<ZonaHorariaDTO>> getZonaHorariasPorPais(@PathVariable(required = true) Integer idPais) {
		List<ZonaHorariaDTO> zonaHorariaDTO = paisService.consultarZonaHorariaPorPais(idPais);
		return new ResponseEntity<>(zonaHorariaDTO, HttpStatus.OK);
	}
}
