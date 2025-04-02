package com.universidad.controller;

import com.universidad.dto.EstudianteDTO;
import com.universidad.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudianteController {

    private final IEstudianteService estudianteService;

    @Autowired
    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes() {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorId(@PathVariable Long id) {
        EstudianteDTO estudiante = estudianteService.obtenerEstudiantePorId(id);
        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudiante);
    }

    // Endpoint PUT para actualizar un estudiante
    @PutMapping("/estudiantes/{id}")
public ResponseEntity<EstudianteDTO> actualizarEstudiante(
        @PathVariable Long id, 
        @RequestBody EstudianteDTO estudianteDTO) {
    EstudianteDTO actualizado = estudianteService.actualizarEstudiante(id, estudianteDTO);
    if (actualizado == null) {
        return ResponseEntity.notFound().build(); // Si no se encuentra el estudiante
    }
    return ResponseEntity.ok(actualizado); // Si la actualización es exitosa
}
 // Endpoint para registrar un nuevo estudiante
 @PostMapping("/estudiantes")
 public ResponseEntity<EstudianteDTO> registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
     // Llamar al servicio para guardar el nuevo estudiante
     EstudianteDTO estudianteCreado = estudianteService.registrarEstudiante(estudianteDTO);
     
     // Devolver el estudiante creado con código 201 Created
     return ResponseEntity.status(201).body(estudianteCreado);
 }

 // Endpoint para eliminar un estudiante por ID
 
 @DeleteMapping("/estudiantes/{id}")
public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
    boolean eliminado = estudianteService.eliminarEstudiante(id);
    if (eliminado) {
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content si la eliminación es exitosa
    } else {
        return ResponseEntity.notFound().build(); // Devuelve 404 si no se encontró el estudiante
    }
}


}
