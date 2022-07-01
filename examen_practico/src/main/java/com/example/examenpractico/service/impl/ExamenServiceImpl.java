package com.example.examenpractico.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.examenpractico.dto.ExamenDTO;
import com.example.examenpractico.dto.PreguntaDTO;
import com.example.examenpractico.dto.RespuestaDTO;
import com.example.examenpractico.errors.RegistroNoEncontradoException;
import com.example.examenpractico.errors.RespuestaCorrectaFaltanteException;
import com.example.examenpractico.errors.RespuestasIncompletasException;
import com.example.examenpractico.model.Examen;
import com.example.examenpractico.model.Pregunta;
import com.example.examenpractico.model.Respuesta;
import com.example.examenpractico.repository.ExamenRepository;
import com.example.examenpractico.repository.PreguntaRepository;
import com.example.examenpractico.repository.RespuestaRepository;
import com.example.examenpractico.service.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	private ExamenRepository examenRepository;

	@Autowired
	private PreguntaRepository preguntaRepository;
	@Autowired
	private RespuestaRepository respuestaRepository;

	@Override
	@Transactional
	public ExamenDTO gardarExamen(ExamenDTO examen) {
		// TODO Auto-generated method stub
		Pregunta pregunta = null;
		Examen examenModel = null;
		Set<Pregunta> preguntas = null;
		if (examen.getPreguntas() != null && !examen.getPreguntas().isEmpty()) {
			examenModel = examenRepository.findByNombreExamen(examen.getNombreExamen());
			if (examenModel != null) {
				throw new RegistroNoEncontradoException("El nombre del examen ya existe");
			}
			preguntas = new HashSet<>();
			Integer puntuacion = 0;
			for (PreguntaDTO preguntaDTO : examen.getPreguntas()) {
				puntuacion += preguntaDTO.getPuntuacion();
			}
			if (puntuacion != 100) {
				throw new RespuestasIncompletasException("La puntuación total del examen debe sumar 100");
			}

			for (PreguntaDTO preguntaDTO : examen.getPreguntas()) {
				Respuesta respuesta = null;
				pregunta = new Pregunta(null, preguntaDTO.getPregunta(), preguntaDTO.getPuntuacion(), null, null);
				pregunta = preguntaRepository.save(pregunta);
				if (preguntaDTO.getRespuestas() != null && !preguntaDTO.getRespuestas().isEmpty()
						&& preguntaDTO.getRespuestas().size() == 4) {
					List<Respuesta> respuestas = new ArrayList<>();
					Integer contadorRespuestaCorrecta = 0;
					char reactivo = 'A';
					for (RespuestaDTO respuestaDTO : preguntaDTO.getRespuestas()) {
						respuesta = new Respuesta(null, respuestaDTO.getRespuesta(), pregunta,
								respuestaDTO.getRespuestaCorrecta(), reactivo);
						if (respuestaDTO.getRespuestaCorrecta()) {
							contadorRespuestaCorrecta++;
						}
						reactivo++;
						respuestas.add(respuesta);
					}
					if (contadorRespuestaCorrecta != 1) {
						throw new RespuestaCorrectaFaltanteException(
								"Se espera respuesta correcta para la pregunta " + pregunta.getPregunta());
					}
					respuestaRepository.saveAll(respuestas);
				} else {
					throw new RespuestasIncompletasException("Se esperan 4 respuestas");
				}
				preguntas.add(pregunta);
			}
		}
		examenModel = new Examen(null, examen.getNombreExamen(), preguntas, null);

		examenModel = examenRepository.save(examenModel);
		return buscarPorId(examenModel.getId());
	}

	@Override
	public ExamenDTO buscarPorId(Integer examenId) {
		Examen examen = null;
		try {
			examen = examenRepository.findById(examenId).get();
		} catch (NoSuchElementException e) {
			throw new RegistroNoEncontradoException("No se encontró el registro Examen");
		}
		ExamenDTO examenDTO = convertirResponse(examen);
		return examenDTO;
	}

	@Override
	public List<ExamenDTO> buscarTodos() {
		List<Examen> examenList = examenRepository.findAll();
		 List<ExamenDTO> examenDTOList = null;
		if(examenList!=null && !examenList.isEmpty()) {
			examenDTOList = new ArrayList<>();
			for(Examen examen : examenList) {
				ExamenDTO examenDTO = convertirResponse(examen);
				examenDTOList.add(examenDTO);
			}
		}
		return examenDTOList;
	}

	private ExamenDTO convertirResponse(Examen examen) {
		ExamenDTO examenDTO = new ExamenDTO();
		examenDTO.setId(examen.getId());
		examenDTO.setNombreExamen(examen.getNombreExamen());
		if (examen.getPreguntas() != null) {
			List<PreguntaDTO> preguntaDTOList = new ArrayList<PreguntaDTO>();
			for (Pregunta pregunta : examen.getPreguntas()) {
				PreguntaDTO preguntaDTO = new PreguntaDTO();
				preguntaDTO.setId(pregunta.getId());
				preguntaDTO.setPregunta(pregunta.getPregunta());
				preguntaDTO.setPuntuacion(pregunta.getPuntos());
				if (pregunta.getRespuestas() != null) {
					List<RespuestaDTO> respuestaDTOList = new ArrayList<RespuestaDTO>();
					for (Respuesta respuesta : pregunta.getRespuestas()) {
						RespuestaDTO respuestaDTO = new RespuestaDTO();
						respuestaDTO.setId(respuesta.getId());
						respuestaDTO.setRespuesta(respuesta.getRespuesta());
						respuestaDTO.setRespuestaCorrecta(respuesta.getRespuestaCorrecta());
						respuestaDTO.setReactivo(respuesta.getReactivo());
						respuestaDTOList.add(respuestaDTO);
					}
					preguntaDTO.setRespuestas(respuestaDTOList);
				}
				preguntaDTOList.add(preguntaDTO);
			}
			examenDTO.setPreguntas(preguntaDTOList);
		}
		return examenDTO;
	}
}
