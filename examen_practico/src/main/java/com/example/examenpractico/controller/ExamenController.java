package com.example.examenpractico.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenpractico.dto.ExamenDTO;
import com.example.examenpractico.service.ExamenService;

@RestController
public class ExamenController {

	@Autowired
	private ExamenService examenServie;

	@RequestMapping(value = "/examen", method = RequestMethod.POST)
	public ResponseEntity<ExamenDTO> guardarExamen(
		@Valid	@RequestBody ExamenDTO examen) {
		ExamenDTO examenDTO = examenServie.gardarExamen(examen);
		return new ResponseEntity<ExamenDTO>(examenDTO, HttpStatus.CREATED);

	}
	
	@RequestMapping(value = "/examen", method = RequestMethod.GET)
	public ResponseEntity<List<ExamenDTO>> obtenerTodos() {
		List<ExamenDTO> examenDTOList = examenServie.buscarTodos();
		return new ResponseEntity<List<ExamenDTO>>(examenDTOList, HttpStatus.OK);

	}
}
