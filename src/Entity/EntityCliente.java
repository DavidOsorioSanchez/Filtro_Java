package Entity;

public class EntityCliente {

    private int ID_Cliente;
    private String Nombre_Cliente;
    private String Apellido;
    private String Email;

    public EntityCliente() {
    }

    public EntityCliente(String nombre_Cliente, String apellido, String email) {
        Nombre_Cliente = nombre_Cliente;
        Apellido = apellido;
        Email = email;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        Nombre_Cliente = nombre_Cliente;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "EntityCliente{" +
                "ID_Cliente=" + ID_Cliente +
                ", Nombre_Cliente='" + Nombre_Cliente + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
