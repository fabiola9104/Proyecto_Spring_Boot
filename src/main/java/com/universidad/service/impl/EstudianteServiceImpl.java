package com.universidad.service.impl;

import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Estudiante;
import com.universidad.repository.EstudianteRepository;
import com.universidad.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @PostConstruct
    public void init() {
        estudianteRepository.init();  // Inicializa los datos de ejemplo
    }

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteDTO obtenerEstudiantePorId(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id);
        return estudiante != null ? convertToDTO(estudiante) : null;
    }

    @Override
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
        Estudiante estudianteExistente = estudianteRepository.findById(id);
        if (estudianteExistente == null) {
            return null; // Si el estudiante no existe, retornar null
        }
        
        // Actualizamos los datos del estudiante con los del DTO
        estudianteExistente.setNombre(estudianteDTO.getNombre());
        estudianteExistente.setApellido(estudianteDTO.getApellido());
        estudianteExistente.setEmail(estudianteDTO.getEmail());
        estudianteExistente.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
        estudianteExistente.setNumeroInscripcion(estudianteDTO.getNumeroInscripcion());

        // Guardamos la actualización y retornamos el DTO actualizado
        Estudiante estudianteGuardado = estudianteRepository.save(estudianteExistente);
        return convertToDTO(estudianteGuardado);
    }

    

@Override
public boolean eliminarEstudiante(Long id) {
    Estudiante estudiante = estudianteRepository.findById(id);
    if (estudiante != null) {
        estudianteRepository.deleteById(id); // Elimina el estudiante
        return true;
    }
    return false; // Devuelve false si el estudiante no fue encontrado
}

    // Método para registrar un nuevo estudiante
    @Override
    public EstudianteDTO registrarEstudiante(EstudianteDTO estudianteDTO) {
        // Convertir el DTO a entidad
        Estudiante estudiante = convertToEntity(estudianteDTO);

        // Guardar el estudiante en el repositorio
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);

        // Convertir la entidad guardada a DTO y retornarlo
        return convertToDTO(estudianteGuardado);
    }
    
    // Convertir de DTO a entidad
    private Estudiante convertToEntity(EstudianteDTO estudianteDTO) {
        return Estudiante.builder()
                .nombre(estudianteDTO.getNombre())
                .apellido(estudianteDTO.getApellido())
                .email(estudianteDTO.getEmail())
                .fechaNacimiento(estudianteDTO.getFechaNacimiento())
                .numeroInscripcion(estudianteDTO.getNumeroInscripcion())
                .build();
    }

    // Convertir de entidad a DTO
    private EstudianteDTO convertToDTO(Estudiante estudiante) {
        return EstudianteDTO.builder()
                .id(estudiante.getId())
                .nombre(estudiante.getNombre())
                .apellido(estudiante.getApellido())
                .email(estudiante.getEmail())
                .fechaNacimiento(estudiante.getFechaNacimiento())
                .numeroInscripcion(estudiante.getNumeroInscripcion())
                .build();
    }
    
}
