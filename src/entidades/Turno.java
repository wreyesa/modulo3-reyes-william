package entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private int id;
    private int pacienteId;
    private int medicoId;
    private LocalDate fecha;
    private LocalTime hora;
    private String especialidad;

    // Constructor vacio
    public Turno(){}

    // Constructor con todos los campos
    public Turno(int id, int pacienteId, int medicoId, LocalDate fecha, LocalTime hora, String especialidad){
        this.id = id;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.fecha = fecha;
        this.hora = hora;
        this.especialidad = especialidad;
    }

    // Getters
    public int getId(){ return id; }
    public int getPacienteId(){ return pacienteId; }
    public int getMedicoId(){ return medicoId; }
    public LocalDate getFecha(){ return fecha; }
    public LocalTime getHora(){ return hora; }
    public String getEspecialidad(){ return especialidad; }

    // Setters
    public void setId(int id){ this.id = id; }
    public void setPacienteId(int pacienteId){ this.pacienteId = pacienteId; }
    public void setMedicoId(int medicoId){ this.medicoId = medicoId; }
    public void setFecha(LocalDate fecha){ this.fecha = fecha; }
    public void setHora(LocalTime hora){ this.hora = hora; }
    public void setEspecialidad(String especialidad){ this.especialidad = especialidad; }

    // toString
    @Override
    public String toString() {
        return "entidades.Turno{" +
                "id=" + id +
                ", pacienteId=" + pacienteId +
                ", medicoId=" + medicoId +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }

}
