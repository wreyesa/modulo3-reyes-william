package persistencia;

import entidades.Turno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {

    // Crear un nuevo turno
    public void crear(Turno turno) {
        String sql = "INSERT INTO turnos (paciente_id, medico_id, fecha, hora, especialidad) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, turno.getPacienteId());
            stmt.setInt(2, turno.getMedicoId());
            stmt.setDate(3, Date.valueOf(turno.getFecha()));
            stmt.setTime(4, Time.valueOf(turno.getHora()));
            stmt.setString(5, turno.getEspecialidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener turno por ID
    public Turno obtenerPorId(int id) {
        String sql = "SELECT * FROM turnos WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Turno turno = new Turno();
                turno.setId(rs.getInt("id"));
                turno.setPacienteId(rs.getInt("paciente_id"));
                turno.setMedicoId(rs.getInt("medico_id"));
                turno.setFecha(rs.getDate("fecha").toLocalDate());
                turno.setHora(rs.getTime("hora").toLocalTime());
                turno.setEspecialidad(rs.getString("especialidad"));
                return turno;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todos los turnos
    public List<Turno> obtenerTodos() {
        List<Turno> turnos = new ArrayList<>();
        String sql = "SELECT * FROM turnos";
        try (Connection connection = ConexionBD.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Turno turno = new Turno();
                turno.setId(rs.getInt("id"));
                turno.setPacienteId(rs.getInt("paciente_id"));
                turno.setMedicoId(rs.getInt("medico_id"));
                turno.setFecha(rs.getDate("fecha").toLocalDate());
                turno.setHora(rs.getTime("hora").toLocalTime());
                turno.setEspecialidad(rs.getString("especialidad"));
                turnos.add(turno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turnos;
    }

    // Actualizar un turno
    public void actualizar(Turno turno) {
        String sql = "UPDATE turnos SET paciente_id = ?, medico_id = ?, fecha = ?, hora = ?, especialidad = ? WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, turno.getPacienteId());
            stmt.setInt(2, turno.getMedicoId());
            stmt.setDate(3, Date.valueOf(turno.getFecha()));
            stmt.setTime(4, Time.valueOf(turno.getHora()));
            stmt.setString(5, turno.getEspecialidad());
            stmt.setInt(6, turno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un turno
    public void eliminar(int id) {
        String sql = "DELETE FROM turnos WHERE id = ?";
        try (Connection connection = ConexionBD.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
