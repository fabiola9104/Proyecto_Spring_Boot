package com.universidad.service;

import com.universidad.dto.EstudianteDTO;

import java.util.List;

public interface IEstudianteService {

    List<EstudianteDTO> obtenerTodosLosEstudiantes();

    EstudianteDTO obtenerEstudiantePorId(Long id);

    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);

    boolean eliminarEstudiante(Long id);

    // Agregar el método para registrar un nuevo estudiante
    EstudianteDTO registrarEstudiante(EstudianteDTO estudianteDTO);
}
