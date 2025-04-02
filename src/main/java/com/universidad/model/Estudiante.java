package com.universidad.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Estudiante extends Persona {
    private String numeroInscripcion; // Número de inscripción específico de Estudiante
}
