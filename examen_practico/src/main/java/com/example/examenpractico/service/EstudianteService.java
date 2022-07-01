package com.example.examenpractico.service;

import java.util.List;

import com.example.examenpractico.dto.EstudianteDTO;
import com.example.examenpractico.dto.EstudianteExamenAltaDTO;
import com.example.examenpractico.dto.ExamenAsignadoDTO;
import com.example.examenpractico.dto.ExamenDTO;
import com.example.examenpractico.dto.GuardarRespuestasDTO;

public interface EstudianteService {
	public EstudianteDTO guardarEstudiante(EstudianteDTO estudianteDTO);

	public ExamenAsignadoDTO asignarExamen(EstudianteExamenAltaDTO estudianteExamenDTO);

	public List<ExamenAsignadoDTO> buscarExamenesAsignados(Integer estudianteId);

	public ExamenDTO obtenerExamen(Integer estudianteId, Integer examenID);

	public ExamenAsignadoDTO guardarRespuestas(Integer estudianteId, GuardarRespuestasDTO guardarRespuestasDTO);
}
