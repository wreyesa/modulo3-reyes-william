package entidades;

public class Medico {
    private int id;
    private String nombre;
    private String especialidad;

    // Constructor vacio
    public Medico(){}

    // Constructor con todos los campos
    public Medico(int id, String nombre, String especialidad){
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getters
    public int getId(){ return id; }
    public String getNombre(){ return nombre; }
    public String getEspecialidad(){ return especialidad; }

    // Setters
    public void setId(int id){ this.id = id; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setEspecialidad(String especialidad){ this.especialidad = especialidad; }

    // toString
    @Override
    public String toString() {
        return "entidades.Medico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }

}
