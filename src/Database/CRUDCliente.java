package Database;

import java.util.List;

public interface CRUDCliente {

    public Object insertarCliente(Object object);
    public boolean actualizarCliente(Object object);
    public  boolean eliminarCliente(Object object);
    public List<Object> encontrarCliente();

}
