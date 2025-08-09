# 🏥 Sistema de Gestión de Turnos Médicos

Este proyecto es un sistema de gestión de turnos médicos desarrollado en **Java puro**, utilizando **JDBC** para la conexión a una base de datos **MySQL**.


## 📌 Características
- Registro de **pacientes** y **médicos**.
- Asignación, consulta y cancelación de **turnos**.
- Arquitectura en capas: **Entidades**, **Persistencia** y **Servicios**.
- Documentación simulada de API REST con **Swagger**.
- Uso de **patrón DAO** para acceso a datos.


## 📂 Estructura del proyecto
src/

├── entidades/ # Clases modelo (Medico, Paciente, Turno)

├── persistencia/ # Clases DAO y conexión a MySQL

├── servicios/ # Lógica de negocio

├── simulacion/ # Controlador simulado para API REST

├── main/ # Clase principal Main.java

├── swagger.yaml # Documentación simulada de API REST

└── bd/ # Script SQL para crear base de datos


## ⚙️ Requisitos
- **Java** 8 o superior
- **MySQL** 8.0+
- **MySQL Connector/J** (JDBC)


## 🚀 Instalación y ejecución
1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/wreyesa/modulo3-reyes-william.git
2. Importar el proyecto en tu IDE (IntelliJ, Eclipse, etc.).
3. Crear la base de datos en MySQL ejecutando: SOURCE src/bd/turnosdb.sql;
4. Configurar credenciales de MySQL en el archivo: src/persistencia/ConexionBD.java
5. Ejecutar la clase Main.java para probar la conexión y funcionalidades.


## 🛠️ Endpoints simulados
La API REST está documentada en el archivo swagger.yaml con las siguientes operaciones simuladas:
- POST /pacientes → Registrar paciente
- GET /turnos/{id} → Obtener turno por ID
- DELETE /turnos/{id} → Cancelar turno

## 🗄️ Base de datos
El script SQL turnosdb.sql crea la base de datos y tablas necesarias:
- pacientes
- medicos
- turnos

Incluye 20 registros de ejemplo para realizar pruebas.
