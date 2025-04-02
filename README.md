# Proyecto Spring Boot - API de Estudiantes

Este proyecto es una API RESTful construida con **Spring Boot** que permite gestionar estudiantes de manera eficiente. La API ofrece operaciones básicas de CRUD (Crear, Leer, Actualizar y Eliminar) para gestionar información de estudiantes dentro de un sistema de base de datos en memoria.

El objetivo de este proyecto es proporcionar una forma sencilla y eficiente de gestionar los datos de los estudiantes, permitiendo operaciones como la creación de nuevos registros, la actualización de registros existentes, la eliminación de registros y la obtención de la lista de todos los estudiantes o la información de un estudiante específico.

## Funcionalidades

### 1. **Crear un Estudiante**
   - **Endpoint**: `POST /api/estudiantes`
   - **Descripción**: Este endpoint permite crear un nuevo estudiante en el sistema.
   - **Parámetros**:
     - Un objeto `EstudianteDTO` en formato JSON con la siguiente estructura:
       ```json
       {
         "nombre": "Juan",
         "apellido": "Pérez",
         "email": "juan.perez@example.com",
         "fechaNacimiento": "2000-05-15",
         "numeroInscripcion": "S001"
       }
       ```
   - **Respuesta**:
     - Retorna el estudiante creado con el código de estado HTTP `201 Created`.
   - **Ejemplo de Respuesta**:
     ```json
     {
       "id": 1,
       "nombre": "Juan",
       "apellido": "Pérez",
       "email": "juan.perez@example.com",
       "fechaNacimiento": "2000-05-15",
       "numeroInscripcion": "S001"
     }
     ```

### 2. **Actualizar un Estudiante Existente**
   - **Endpoint**: `PUT /api/estudiantes/{id}`
   - **Descripción**: Permite actualizar la información de un estudiante existente, identificado por su `id`.
   - **Parámetros**:
     - El `id` del estudiante a actualizar debe ser proporcionado en la URL, y los nuevos datos se pasan como un objeto `EstudianteDTO` en el cuerpo de la solicitud.
   - **Ejemplo de Solicitud**:
     ```json
     {
       "nombre": "Juan Carlos",
       "apellido": "Pérez",
       "email": "juan.carlos.perez@example.com",
       "fechaNacimiento": "2000-05-15",
       "numeroInscripcion": "S001"
     }
     ```
   - **Respuesta**:
     - Retorna el estudiante actualizado con código de estado HTTP `200 OK`.
   - **Ejemplo de Respuesta**:
     ```json
     {
       "id": 1,
       "nombre": "Juan Carlos",
       "apellido": "Pérez",
       "email": "juan.carlos.perez@example.com",
       "fechaNacimiento": "2000-05-15",
       "numeroInscripcion": "S001"
     }
     ```

### 3. **Eliminar un Estudiante**
   - **Endpoint**: `DELETE /api/estudiantes/{id}`
   - **Descripción**: Este endpoint permite eliminar un estudiante utilizando su `id`.
   - **Parámetros**:
     - El `id` del estudiante a eliminar se pasa como parámetro en la URL.
   - **Respuesta**:
     - Retorna un código de estado HTTP `204 No Content` si la eliminación fue exitosa.
   - **Ejemplo de Respuesta**:
     - No hay cuerpo en la respuesta, solo un código de estado HTTP.

### 4. **Obtener un Estudiante por ID**
   - **Endpoint**: `GET /api/estudiantes/{id}`
   - **Descripción**: Este endpoint permite obtener la información de un estudiante específico por su `id`.
   - **Parámetros**:
     - El `id` del estudiante se pasa como parte de la URL.
   - **Respuesta**:
     - Retorna un objeto `EstudianteDTO` con los datos del estudiante o un código de estado `404 Not Found` si el estudiante no existe.
   - **Ejemplo de Respuesta**:
     ```json
     {
       "id": 1,
       "nombre": "Juan Carlos",
       "apellido": "Pérez",
       "email": "juan.carlos.perez@example.com",
       "fechaNacimiento": "2000-05-15",
       "numeroInscripcion": "S001"
     }
     ```

### 5. **Obtener Todos los Estudiantes**
   - **Endpoint**: `GET /api/estudiantes`
   - **Descripción**: Este endpoint permite obtener la lista de todos los estudiantes registrados en el sistema.
   - **Respuesta**:
     - Retorna un array de objetos `EstudianteDTO`.
   - **Ejemplo de Respuesta**:
     ```json
     [
       {
         "id": 1,
         "nombre": "Juan Carlos",
         "apellido": "Pérez",
         "email": "juan.carlos.perez@example.com",
         "fechaNacimiento": "2000-05-15",
         "numeroInscripcion": "S001"
       },
       {
         "id": 2,
         "nombre": "María",
         "apellido": "González",
         "email": "maria.gonzalez@example.com",
         "fechaNacimiento": "2001-08-22",
         "numeroInscripcion": "S002"
       }
     ]
     ```

## Instrucciones de Ejecución

### Requisitos Previos

- Java 17 o superior.
- Maven 3.6 o superior.
- Un IDE compatible como **IntelliJ IDEA** o **Eclipse** (opcional).

### Pasos para Ejecutar el Proyecto

1. **Clonar el repositorio**:
   Si aún no has clonado el proyecto, usa el siguiente comando:
   ```bash
   git clone https://github.com/fabiola9104/Proyecto_Spring_Boot.git
