package Entity;

public class EntityTienda {
    private int ID_Tienda;
    private String NombreTienda;
    private String Ubicacion;

    public EntityTienda() {
    }

    public EntityTienda(String nombreTienda, String ubicacion) {
        NombreTienda = nombreTienda;
        Ubicacion = ubicacion;
    }

    public int getID_Tienda() {
        return ID_Tienda;
    }

    public void setID_Tienda(int ID_Tienda) {
        this.ID_Tienda = ID_Tienda;
    }

    public String getNombreTienda() {
        return NombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        NombreTienda = nombreTienda;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "EntityTienda{" +
                "ID_Tienda=" + ID_Tienda +
                ", NombreTienda='" + NombreTienda + '\'' +
                ", Ubicacion='" + Ubicacion + '\'' +
                '}';
    }
}
