package servicios;

import entidades.Medico;
import persistencia.MedicoDAO;

import java.util.List;

public class MedicoService {
    private MedicoDAO medicoDAO;

    public MedicoService(MedicoDAO medicoDAO) {
        this.medicoDAO = medicoDAO;
    }

    public void registrarMedico(Medico medico) {
        // Validaciones básicas
        if (medico.getNombre() == null || medico.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del médico no puede estar vacío");
        }

        if (medico.getEspecialidad() == null || medico.getEspecialidad().trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía");
        }

        medicoDAO.crear(medico);
    }

    public Medico obtenerMedico(int id) {
        Medico medico = medicoDAO.obtenerPorId(id);
        if (medico == null) {
            throw new IllegalArgumentException("No se encontró el médico con ID: " + id);
        }
        return medico;
    }

    public void actualizarMedico(Medico medico) {
        // Aquí también podrías poner validaciones si lo deseas
        medicoDAO.actualizar(medico);
    }

    public void eliminarMedico(int id) {
        medicoDAO.eliminar(id);
    }

    public List<Medico> listarMedicos() {
        return medicoDAO.obtenerTodos();
    }
}
