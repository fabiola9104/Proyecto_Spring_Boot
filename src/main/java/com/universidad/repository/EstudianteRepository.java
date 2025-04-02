package com.universidad.repository;

import com.universidad.model.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDate;

@Repository
public class EstudianteRepository {

    private final Map<Long, Estudiante> estudiantes = new ConcurrentHashMap<>();
    private final AtomicLong idContador = new AtomicLong(1);

    // Guarda un estudiante en el repositorio (en memoria)
    public Estudiante save(Estudiante estudiante) {
        if (estudiante.getId() == null) {
            estudiante.setId(idContador.getAndIncrement());
        }
        estudiantes.put(estudiante.getId(), estudiante);
        return estudiante;
    }

    // Obtiene todos los estudiantes almacenados en memoria
    public List<Estudiante> findAll() {
        return new ArrayList<>(estudiantes.values());
    }

    // Busca un estudiante por su ID
    public Estudiante findById(Long id) {
        return estudiantes.get(id);
    }

    public void deleteById(Long id) {
        estudiantes.remove(id); // Elimina el estudiante con el ID proporcionado
    }

    // Método para inicializar algunos datos de ejemplo
    public void init() {
        Estudiante estudiante1 = Estudiante.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .email("juan.perez@example.com")
                .fechaNacimiento(LocalDate.of(2000, 5, 15))
                .numeroInscripcion("S001")
                .build();

        Estudiante estudiante2 = Estudiante.builder()
                .nombre("María")
                .apellido("González")
                .email("maria.gonzalez@example.com")
                .fechaNacimiento(LocalDate.of(2001, 8, 22))
                .numeroInscripcion("S002")
                .build();

        save(estudiante1);
        save(estudiante2);
    }
}
