package Entity;

public class EntityProducto {
    private int ID_Producto;
    private String NombreProducto;
    private double Precio;
    private int stock;
    private int FK_Id_Tienda;
    private  EntityTienda entidadTienda;

    public EntityProducto() {
    }

    public EntityProducto(String nombreProducto, double precio, int stock, int FK_Id_Tienda, EntityTienda entidadTienda) {
        NombreProducto = nombreProducto;
        Precio = precio;
        this.stock = stock;
        this.FK_Id_Tienda = FK_Id_Tienda;
        this.entidadTienda = entidadTienda;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getFK_Id_Tienda() {
        return FK_Id_Tienda;
    }

    public void setFK_Id_Tienda(int FK_Id_Tienda) {
        this.FK_Id_Tienda = FK_Id_Tienda;
    }

    public EntityTienda getEntidadTienda(EntityTienda objTienda) {
        return entidadTienda;
    }

    public void setEntidadTienda(EntityTienda entidadTienda) {
        this.entidadTienda = entidadTienda;
    }

    @Override
    public String toString() {
        return "EntityProducto{" +
                "ID_Producto=" + ID_Producto +
                ", NombreProducto='" + NombreProducto + '\'' +
                ", Precio=" + Precio +
                ", stock=" + stock +
                ", FK_Id_Tienda=" + FK_Id_Tienda +
                ", entidadTienda=" + entidadTienda +
                '}';
    }
}
