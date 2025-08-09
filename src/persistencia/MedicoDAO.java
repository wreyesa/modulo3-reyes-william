package persistencia;

import entidades.Medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    // Crear un nuevo médico
    public void crear(Medico medico) {
        String sql = "INSERT INTO medicos (nombre, especialidad) VALUES (?, ?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getEspecialidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener médico por ID
    public Medico obtenerPorId(int id) {
        String sql = "SELECT * FROM medicos WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setNombre(rs.getString("nombre"));
                medico.setEspecialidad(rs.getString("especialidad"));
                return medico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todos los médicos
    public List<Medico> obtenerTodos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medicos";
        try (Connection connection = ConexionBD.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setNombre(rs.getString("nombre"));
                medico.setEspecialidad(rs.getString("especialidad"));
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }

    // Actualizar un médico
    public void actualizar(Medico medico) {
        String sql = "UPDATE medicos SET nombre = ?, especialidad = ? WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medico.getNombre());
            stmt.setString(2, medico.getEspecialidad());
            stmt.setInt(3, medico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un médico
    public void eliminar(int id) {
        String sql = "DELETE FROM medicos WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
