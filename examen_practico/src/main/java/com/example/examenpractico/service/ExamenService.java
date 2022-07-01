package com.example.examenpractico.service;

import java.util.List;

import com.example.examenpractico.dto.ExamenDTO;

public interface ExamenService {

	public ExamenDTO gardarExamen(ExamenDTO examen);
	public ExamenDTO buscarPorId(Integer examenId);
	public List<ExamenDTO> buscarTodos();
}
