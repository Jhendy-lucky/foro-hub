# Foro Hub

Foro Hub para el challenge 2 de la formación Java y Spring Framework de Alura Latam

## Funcionalidades Principales 🚀

### CRUD de Tópicos
- **Crear**: Permite a los usuarios agregar nuevos tópicos al foro.
- **Leer**: Ofrece dos opciones:
  - Ver todos los tópicos disponibles.
  - Ver un único tópico específico utilizando su identificador.
- **Actualizar**: Modificar el contenido de un tópico existente.
- **Eliminar**: Eliminar un tópico de manera permanente.

### Validaciones de Negocio
- Validación de datos enviados por los usuarios al crear o actualizar tópicos.
- Restricciones que aseguran la integridad y la coherencia de la información.

### Persistencia de Datos
- Implementación de una base de datos relacional para almacenar la información de los tópicos.
- Uso de **JPA** para la gestión de las operaciones con la base de datos.

### Seguridad y Autenticación 🔒
- Sistema de autenticación para identificar y autorizar a los usuarios.
- Restricción de acceso según los roles definidos (por ejemplo: usuarios comunes, moderadores, administradores).

---

## Tecnologías Utilizadas 🛠️

- **Java 11** o superior.
- **Spring Boot** para el desarrollo rápido de la API.
- **Spring Data JPA** para la gestión de la base de datos.
- **Spring Security** para la autenticación y autorización.
- **MySQL** (o cualquier base de datos SQL compatible) para la persistencia de datos.
- **Postman** o similar para probar los endpoints.

---

## Endpoints Disponibles 🛣️

| Método | Endpoint       | Descripción                      |
|--------|----------------|----------------------------------|
| POST   | `/topics`      | Crear un nuevo tópico.          |
| GET    | `/topics`      | Listar todos los tópicos.       |
| GET    | `/topics/{id}` | Mostrar un tópico específico.   |
| PUT    | `/topics/{id}` | Actualizar un tópico existente. |
| DELETE | `/topics/{id}` | Eliminar un tópico.             |

---

## Cómo Ejecutar el Proyecto ▶️

### Prerrequisitos
1. **Java 11** o superior.
2. **Maven** o **Gradle** como herramienta de construcción.
3. Una base de datos SQL como **MySQL**.

### Pasos para Configuración
1. Clona este repositorio en tu máquina local.
   ```bash
   git clone https://github.com/usuario/foro-hub.git
