CREATE DATABASE turnosdb;

USE turnosdb;

CREATE TABLE pacientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    dni VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE medicos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    especialidad VARCHAR(50)
);

CREATE TABLE turnos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT,
    medico_id INT,
    fecha DATE,
    hora TIME,
    especialidad VARCHAR(50),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id),
    FOREIGN KEY (medico_id) REFERENCES medicos(id)
);

-- Pacientes
INSERT INTO pacientes (nombre, dni, email) VALUES
('Juan Pérez', '12345678', 'juan.perez@example.com'),
('María López', '87654321', 'maria.lopez@example.com'),
('Carlos García', '45678912', 'carlos.garcia@example.com'),
('Lucía Fernández', '78912345', 'lucia.fernandez@example.com'),
('Pedro Sánchez', '32165498', 'pedro.sanchez@example.com'),
('Ana Torres', '65498732', 'ana.torres@example.com'),
('Luis Ramírez', '14725836', 'luis.ramirez@example.com'),
('Carmen Díaz', '36985214', 'carmen.diaz@example.com');

-- Médicos
INSERT INTO medicos (nombre, especialidad) VALUES
('Dr. Roberto Medina', 'Cardiología'),
('Dra. Sofía Rojas', 'Pediatría'),
('Dr. Andrés Villanueva', 'Dermatología'),
('Dra. Elena Vargas', 'Oftalmología'),
('Dr. Miguel Castillo', 'Neurología');

-- Turnos
INSERT INTO turnos (paciente_id, medico_id, fecha, hora, especialidad) VALUES
(1, 1, '2025-08-15', '09:00:00', 'Cardiología'),
(2, 1, '2025-08-16', '10:30:00', 'Cardiología'),
(3, 2, '2025-08-17', '11:00:00', 'Pediatría'),
(4, 3, '2025-08-18', '14:00:00', 'Dermatología'),
(5, 4, '2025-08-19', '15:30:00', 'Oftalmología'),
(6, 5, '2025-08-20', '08:45:00', 'Neurología'),
(7, 2, '2025-08-21', '09:15:00', 'Pediatría');
