package Controller;

import javax.swing.*;

import Entity.EntityProducto;
import Entity.EntityTienda;
import Model.ModelProducto;
import Util.Util;

import java.util.List;

public class ProductoController {

    public static ModelProducto instaceModel(){
        return new ModelProducto();
    }
    public static void insert(){
        String nombreProducto = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto");
        double precio = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa el precio del producto"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa cuanto stock hay"));
        Object[] opcionesTienda = Util.listArray(TiendaController.instaceModel().listarTiendas());

        EntityTienda objTienda = (EntityTienda) JOptionPane.showInputDialog(null, "selecciona la tienda", "no titulo", JOptionPane.QUESTION_MESSAGE, null, opcionesTienda, opcionesTienda[0]);
        instaceModel().insertarProducto(new EntityProducto(nombreProducto, precio,stock,objTienda.getID_Tienda(), objTienda));
    }

    public static  void listarNombre(){

        String list = listarNombre(instaceModel().encontrarProductoNombre());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String listarNombre(List<Object> listado){
        String lista = "Listado de productos";

        for (Object obj : listado){
            EntityProducto objModelos = (EntityProducto) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

    public static  void listarTienda(){

        String list = listarTienda(instaceModel().encontrarProductoTienda());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String listarTienda(List<Object> listado){
        String lista = "Listado de productos";

        for (Object obj : listado){
            EntityProducto objModelos = (EntityProducto) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

    public static void borrar(){
        Object[] optionsborrar = Util.listArray(instaceModel().encontrarProductoNombre());

        EntityProducto objSelected = (EntityProducto) JOptionPane.showInputDialog(null, "selecciona un producto","",JOptionPane.QUESTION_MESSAGE, null,optionsborrar,optionsborrar[0]);

        instaceModel().eliminarProducto(objSelected);
    }

    public static void update(){
        Object[] optionsU = Util.listArray(instaceModel().encontrarProductoNombre());
        EntityProducto objSelected = (EntityProducto) JOptionPane.showInputDialog(null, "selecciona el producto que quieres para actualizar","",JOptionPane.QUESTION_MESSAGE, null,optionsU,optionsU[0]);

        String newNombreProducto = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del producto",objSelected.getNombreProducto());
        double newPrecio = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa el nuevo precio del producto",objSelected.getPrecio()));
        int newStock = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa cuanta cantidad de nuevo stock hay",objSelected.getStock()));

        Object[] opcionesTienda = Util.listArray(TiendaController.instaceModel().listarTiendas());
        EntityTienda objTienda= (EntityTienda) JOptionPane.showInputDialog(null, "selecciona una tienda","",JOptionPane.QUESTION_MESSAGE, null,opcionesTienda,opcionesTienda[0]);


        instaceModel().actualizarProducto(new EntityProducto(newNombreProducto,newPrecio,newStock,objTienda.getID_Tienda(),objTienda));
    }
}
