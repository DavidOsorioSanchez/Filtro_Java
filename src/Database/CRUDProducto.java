package Database;

import java.util.List;

public interface CRUDProducto {

    public Object insertarProducto(Object object);
    public boolean actualizarProducto(Object object);
    public  boolean eliminarProducto(Object object);
    public List<Object> encontrarProductoTienda();
    public List<Object> encontrarProductoNombre();

}
