package servicios;

import entidades.Turno;
import persistencia.TurnoDAO;

import java.time.LocalDate;
import java.util.List;

public class TurnoService {
    private TurnoDAO turnoDAO;

    public TurnoService(TurnoDAO turnoDAO){
        this.turnoDAO = turnoDAO;
    }

    public void registrarTurno(Turno turno){
        // validacion: no se permite agendar en fechas pasadas
        if (turno.getFecha().isBefore(LocalDate.now())){
            throw new IllegalArgumentException("No se puede agendar un turno en una fecha pasada");
        }

        // validacion: debe tener paciente y medico
        if (turno.getPacienteId() <= 0 || turno.getMedicoId() <= 0){
            throw new IllegalArgumentException("El turno debe tener un paciente y un medico asignado");
        }

        turnoDAO.crear(turno);
    }

    public Turno obtenerTurno(int id) {
        return turnoDAO.obtenerPorId(id);
    }

    public List<Turno> listarTurnos() {
        return turnoDAO.obtenerTodos();
    }

    public void actualizarTurno(Turno turno) {
        turnoDAO.actualizar(turno);
    }

    public void cancelarTurno(int id) {
        turnoDAO.eliminar(id);
    }
}
