package com.example.examenpractico.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examenpractico.dto.CiudadDTO;
import com.example.examenpractico.dto.EstudianteDTO;
import com.example.examenpractico.dto.EstudianteExamenAltaDTO;
import com.example.examenpractico.dto.ExamenAsignadoDTO;
import com.example.examenpractico.dto.ExamenDTO;
import com.example.examenpractico.dto.GuardarRespuestasDTO;
import com.example.examenpractico.dto.PreguntaDTO;
import com.example.examenpractico.dto.RespuestaDTO;
import com.example.examenpractico.dto.ZonaHorariaDTO;
import com.example.examenpractico.errors.RegistroNoEncontradoException;
import com.example.examenpractico.errors.ZonaHorariaErroneaException;
import com.example.examenpractico.model.Ciudad;
import com.example.examenpractico.model.Estudiante;
import com.example.examenpractico.model.EstudianteExamen;
import com.example.examenpractico.model.Examen;
import com.example.examenpractico.model.Respuesta;
import com.example.examenpractico.model.RespuestaEstudiante;
import com.example.examenpractico.model.ZonaHoraria;
import com.example.examenpractico.repository.EstudianteExamenRepository;
import com.example.examenpractico.repository.EstudianteRepository;
import com.example.examenpractico.repository.RespuestaRepository;
import com.example.examenpractico.service.CiudadService;
import com.example.examenpractico.service.EstudianteService;
import com.example.examenpractico.service.ExamenService;
import com.example.examenpractico.service.ZonaHorariaService;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private CiudadService ciudadService;
	@Autowired
	private EstudianteRepository estudianteRepository;
	@Autowired
	private ZonaHorariaService zonaHorariaService;
	@Autowired
	private ExamenService examenService;
	@Autowired
	private EstudianteExamenRepository estudianteExamenRepository;

	@Autowired
	private RespuestaRepository respuestaRepository;

	@Override
	public EstudianteDTO guardarEstudiante(EstudianteDTO estudianteDTO) {
		CiudadDTO ciudadDTO = ciudadService.consultarCiudadPorID(estudianteDTO.getIdCiudad());
		ZonaHorariaDTO zonaHorariaDTO = zonaHorariaService.buscarPorId(estudianteDTO.getZonaHoraria());
		if (!zonaHorariaDTO.getPaisId().equals(ciudadDTO.getPaisID())) {
			throw new ZonaHorariaErroneaException("Zona horaria y ciudad no coincide");
		}

		Estudiante estudiante = new Estudiante();
		estudiante.setApellidoMaterno(estudianteDTO.getApellidoMaterno());
		estudiante.setApellidoPaterno(estudianteDTO.getApellidoPaterno());
		Ciudad ciudad = new Ciudad();
		ciudad.setId(ciudadDTO.getId());
		estudiante.setCiudad(ciudad);

		estudiante.setEdad(estudianteDTO.getEdad());
		estudiante.setNombre(estudianteDTO.getNombre());

		ZonaHoraria zonaHoraria = new ZonaHoraria();
		zonaHoraria.setId(zonaHorariaDTO.getId());
		estudiante.setZonaHoraria(zonaHoraria);
		estudiante = estudianteRepository.save(estudiante);
		estudianteDTO.setId(estudiante.getId());
		return estudianteDTO;
	}

	@Override
	public ExamenAsignadoDTO asignarExamen(EstudianteExamenAltaDTO estudianteExamenDTO) {
		Estudiante estudiante = consultarEstudiantePorId(estudianteExamenDTO.getEstudianteId());
		ZonaHoraria zonaHoraria = estudiante.getZonaHoraria();
		ZonedDateTime fechaAsignacionOrigen = estudianteExamenDTO.getFechaAsignacion().atZone(ZoneId.systemDefault());
		ZonedDateTime fechaAsignacion = fechaAsignacionOrigen
				.withZoneSameInstant(ZoneId.of(zonaHoraria.getZonaHoraria()));

		ExamenDTO examenDTO = examenService.buscarPorId(estudianteExamenDTO.getExamenId());
		Examen examen = new Examen();
		examen.setId(examenDTO.getId());
		EstudianteExamen estudianteExamen = estudianteExamenRepository.findByEstudianteAndExamen(estudiante, examen);
		if (estudianteExamen != null) {
			throw new RegistroNoEncontradoException("El examen ya fue asignado");
		} else {
			estudianteExamen = new EstudianteExamen();
		}

		estudianteExamen.setEstudiante(estudiante);
		estudianteExamen.setFechaAsignacion(fechaAsignacion.toLocalDateTime());
		estudianteExamen.setExamen(examen);

		estudianteExamenRepository.save(estudianteExamen);
		return convertirEstuExamDTO(estudianteExamen);

	}

	private Estudiante consultarEstudiantePorId(Integer estudianteId) {
		Estudiante estudiante = null;

		try {
			estudiante = estudianteRepository.findById(estudianteId).get();
		} catch (NoSuchElementException e) {
			throw new RegistroNoEncontradoException("No se encontró el registro Estudiante");
		}
		return estudiante;
	}

	@Override
	public List<ExamenAsignadoDTO> buscarExamenesAsignados(Integer estudianteId) {
		List<ExamenAsignadoDTO> examenAsignadoDTOList = null;
		Estudiante estudiante = consultarEstudiantePorId(estudianteId);
		List<EstudianteExamen> estudianteExamenList = estudianteExamenRepository.findByEstudiante(estudiante);
		if (estudianteExamenList == null || estudianteExamenList.isEmpty()) {
			throw new RegistroNoEncontradoException("No se encontró el registro Examen");
		}
		examenAsignadoDTOList = new ArrayList<>();
		for (EstudianteExamen estudianteExamen : estudianteExamenList) {
			examenAsignadoDTOList.add(convertirEstuExamDTO(estudianteExamen));
		}
		return examenAsignadoDTOList;
	}

	private ExamenAsignadoDTO convertirEstuExamDTO(EstudianteExamen estudianteExamen) {
		ExamenAsignadoDTO examenAsignadoDTO = new ExamenAsignadoDTO(estudianteExamen.getId(),
				estudianteExamen.getExamen().getId(), estudianteExamen.getExamen().getNombreExamen(),
				estudianteExamen.getFechaAsignacion(), estudianteExamen.getFechaPresentacion(),estudianteExamen.getCalificacion() );
	
		return examenAsignadoDTO;
	}

	@Override
	public ExamenDTO obtenerExamen(Integer estudianteId, Integer examenEstudianteId) {
		EstudianteExamen estudianteExamen = obtenerEstudianteExamenById(estudianteId, examenEstudianteId);
		ExamenDTO examenDTO = examenService.buscarPorId(estudianteExamen.getExamen().getId());
		return examenDTO;
	}

	@Override
	public ExamenAsignadoDTO guardarRespuestas(Integer examenEstudianteId, GuardarRespuestasDTO guardarRespuestasDTO) {
		EstudianteExamen estudianteExamen = obtenerEstudianteExamenById(examenEstudianteId,
				guardarRespuestasDTO.getExamenEstudianteId());
		Set<RespuestaEstudiante> respuestaEstudianteList = new HashSet();
		if (estudianteExamen.getExamen().getPreguntas().size() != guardarRespuestasDTO.getPreguntas().size()) {
			throw new RegistroNoEncontradoException("Hay preguntas sin responder");
		}
		Integer puntuacion = 0;
		for (PreguntaDTO preguntaDTO : guardarRespuestasDTO.getPreguntas()) {
			for (RespuestaDTO respuestaDTO : preguntaDTO.getRespuestas()) {
				RespuestaEstudiante respuestaEstudiante = new RespuestaEstudiante();
				respuestaEstudiante.setEstudianteExamen(estudianteExamen);
				Respuesta respuesta = null;
				try {
					respuesta = respuestaRepository.findById(respuestaDTO.getId()).get();
				} catch (NoSuchElementException e) {
					throw new RegistroNoEncontradoException("No se encontró el registro Respuesta");
				}

				if (!respuesta.getPregunta().getId().equals(preguntaDTO.getId())) {
					throw new RegistroNoEncontradoException("Una respuesta no coincide con la pregunta");
				}
				if (!estudianteExamen.getExamen().getPreguntas().contains(respuesta.getPregunta())) {
					throw new RegistroNoEncontradoException("La pregunta no corresponde al examen");
				}
				if (respuesta.getRespuestaCorrecta()) {
					puntuacion = puntuacion + respuesta.getPregunta().getPuntos();
				}
				respuestaEstudiante.setRespuesta(respuesta);
				ZonaHoraria zonaHoraria = estudianteExamen.getEstudiante().getZonaHoraria();
				ZonedDateTime fechaPresentacionOrigen = guardarRespuestasDTO.getFechaPresentacion()
						.atZone(ZoneId.systemDefault());
				ZonedDateTime fechaDestino = fechaPresentacionOrigen
						.withZoneSameInstant(ZoneId.of(zonaHoraria.getZonaHoraria()));

				estudianteExamen.setFechaPresentacion(fechaDestino.toLocalDateTime());
				respuestaEstudiante.setEstudianteExamen(estudianteExamen);
				respuestaEstudianteList.add(respuestaEstudiante);
			}

		}
		estudianteExamen.setCalificacion(puntuacion);
		estudianteExamen.setRespuestasEstudiante(respuestaEstudianteList);

		estudianteExamen = estudianteExamenRepository.save(estudianteExamen);
		return convertirEstuExamDTO(estudianteExamen);
	}

	private EstudianteExamen obtenerEstudianteExamenById(Integer estudianteId, Integer examenEstudianteId) {
		Estudiante estudiante = consultarEstudiantePorId(estudianteId);
		EstudianteExamen estudianteExamen = null;
		try {
			estudianteExamen = estudianteExamenRepository.findByEstudianteAndId(estudiante, examenEstudianteId);
		} catch (NoSuchElementException e) {
			throw new RegistroNoEncontradoException("No se encontró el registro Estudiante - Examen");
		}
		return estudianteExamen;
	}
}
