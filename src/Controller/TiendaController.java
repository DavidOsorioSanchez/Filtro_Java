package Controller;

import Entity.EntityTienda;
import Model.ModelTienda;

import javax.swing.*;
import java.util.List;

public class TiendaController {
    public static ModelTienda instaceModel(){
        return new ModelTienda();
    }

//    getAll

    public static  void listar(){

        String list = listar(instaceModel().listarTiendas());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String listar(List<Object> listado){
        String lista = "Listado de las tiendas";

        for (Object obj : listado){
            EntityTienda objModelos = (EntityTienda) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }
}
