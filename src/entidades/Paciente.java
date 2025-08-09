package entidades;

public class Paciente {
    private int id;
    private String nombre;
    private String dni;
    private String email;

    // Constructor vacio - necesario para JDBC
    public Paciente() {
    }

    // Constructor con todos los campos
    public Paciente(int id, String nombre, String dni, String email){
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
    }

    // Getters
    public int getId(){ return id; }
    public String getNombre() { return nombre; }
    public String getDni(){ return dni; }
    public String getEmail(){ return email; }

    // Setters
    public void setId(int id){ this.id = id; }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public void setDni(String dni){ this.dni = dni; }
    public void setEmail(String email){ this.email = email; }

    // toString para mostrar el objeto como texto
    @Override
    public String toString(){
        return "entidades.Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
