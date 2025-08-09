package persistencia;

import entidades.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public PacienteDAO(Connection connection) {
    }

    // Crear un nuevo paciente
    public void crear(Paciente paciente){
        String sql = "INSERT INTO pacientes (nombre, dni, email) VALUES (?, ?, ?)";
        try (Connection connection = ConexionBD.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getDni());
            stmt.setString(3, paciente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener un paciente por ID
    public Paciente obtenerPorId(int id){
        String sql = "SELECT * FROM pacientes WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getString("dni"));
                paciente.setEmail(rs.getString("email"));
                return paciente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todos los pacientes
    public List<Paciente> obtenerTodos(){
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM pacientes";
        try (Connection connection = ConexionBD.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getString("dni"));
                paciente.setEmail(rs.getString("email"));
                pacientes.add(paciente);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return pacientes;
    }

    // Actualizar un paciente
    public void actualizar(Paciente paciente) {
        String sql = "UPDATE pacientes SET nombre = ?, dni = ?, email = ? WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getDni());
            stmt.setString(3, paciente.getEmail());
            stmt.setInt(4, paciente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un paciente por ID
    public void eliminar(int id) {
        String sql = "DELETE FROM pacientes WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
