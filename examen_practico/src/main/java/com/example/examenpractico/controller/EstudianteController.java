package com.example.examenpractico.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.examenpractico.dto.EstudianteDTO;
import com.example.examenpractico.dto.EstudianteExamenAltaDTO;
import com.example.examenpractico.dto.ExamenAsignadoDTO;
import com.example.examenpractico.dto.ExamenDTO;
import com.example.examenpractico.dto.GuardarRespuestasDTO;
import com.example.examenpractico.service.EstudianteService;

@RestController
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;

	@RequestMapping(value = "/estudiante", method = RequestMethod.POST)
	public ResponseEntity<EstudianteDTO> guardarEstudiante(@Valid @RequestBody EstudianteDTO estudianteDTO) {
		estudianteDTO = estudianteService.guardarEstudiante(estudianteDTO);
		return new ResponseEntity<>(estudianteDTO, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/estudiante/{idEstudiante}/examen", method = RequestMethod.POST)
	public ResponseEntity<ExamenAsignadoDTO> asignarExamen(@PathVariable(required = true) Integer idEstudiante,
			@Valid @RequestBody EstudianteExamenAltaDTO estudianteExamenDTO) {
		EstudianteDTO estudianteDTO = new EstudianteDTO();
		estudianteDTO.setId(idEstudiante);
		estudianteExamenDTO.setEstudianteId(idEstudiante);
		ExamenAsignadoDTO examenAsignadoDTO = estudianteService.asignarExamen(estudianteExamenDTO);
		return new ResponseEntity<>(examenAsignadoDTO, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/estudiante/{idEstudiante}/examen-estudiante", method = RequestMethod.GET)
	public ResponseEntity<List<ExamenAsignadoDTO>> consultarExamenPorEstu(
			@PathVariable(required = true) Integer idEstudiante) {
		List<ExamenAsignadoDTO> examenAsignadoDTOList = estudianteService.buscarExamenesAsignados(idEstudiante);
		return new ResponseEntity<>(examenAsignadoDTOList, HttpStatus.OK);

	}

	@RequestMapping(value = "/estudiante/{idEstudiante}/examen-estudiante/{idExamenEstudiante}", method = RequestMethod.GET)
	public ResponseEntity<ExamenDTO> obtenerExamen(@PathVariable(required = true) Integer idEstudiante,
			@PathVariable(required = true) Integer idExamenEstudiante) {
		ExamenDTO examenDTO = estudianteService.obtenerExamen(idEstudiante, idExamenEstudiante);
		return new ResponseEntity<>(examenDTO, HttpStatus.OK);

	}

	@RequestMapping(value = "/estudiante/{idEstudiante}/examen-estudiante", method = RequestMethod.PUT)
	public ResponseEntity<ExamenAsignadoDTO> guardarRespuestas(@PathVariable(required = true) Integer idEstudiante,
			@Valid @RequestBody GuardarRespuestasDTO guardarRespuestasDTO) {
		ExamenAsignadoDTO examenAsignadoDTO = estudianteService.guardarRespuestas(idEstudiante, guardarRespuestasDTO);
		return new ResponseEntity<>(examenAsignadoDTO, HttpStatus.CREATED);

	}
}
