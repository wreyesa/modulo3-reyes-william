package main;

import entidades.Paciente;
import persistencia.ConexionBD;
import persistencia.PacienteDAO;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = ConexionBD.getConnection()) {
            System.out.println("Conexión a MySQL exitosa.");

            // Crear DAO
            PacienteDAO pacienteDAO = new PacienteDAO(connection);

            // 1️⃣ Crear paciente
            Paciente nuevoPaciente = new Paciente();
            nuevoPaciente.setNombre("Juan Pérez");
            nuevoPaciente.setDni("12345678");
            nuevoPaciente.setEmail("juan@example.com");
            pacienteDAO.crear(nuevoPaciente);
            System.out.println("Paciente creado.");

            // 2️⃣ Listar pacientes
            List<Paciente> listaPacientes = pacienteDAO.obtenerTodos();
            System.out.println("Lista de pacientes:");
            for (Paciente p : listaPacientes) {
                System.out.println(p.getId() + " - " + p.getNombre());
            }

            // 3️⃣ Obtener por ID
            Paciente paciente = pacienteDAO.obtenerPorId(1);
            if (paciente != null) {
                System.out.println("Paciente encontrado: " + paciente.getNombre());
            }

            // 4️⃣ Actualizar paciente
            if (paciente != null) {
                paciente.setNombre("Juan Pérez Actualizado");
                pacienteDAO.actualizar(paciente);
                System.out.println("Paciente actualizado.");
            }

            // 5️⃣ Eliminar paciente
            //pacienteDAO.eliminar(1);
            //System.out.println("Paciente eliminado.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
