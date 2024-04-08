package Controller;

import Entity.EntityCliente;
import Model.ModelCliente;
import Util.Util;

import javax.swing.*;
import java.util.List;

public class ClienteController {

    //    insertar
    public static void insert(){
        String name = JOptionPane.showInputDialog(null,"Ingresa el nombre del cliente.");
        String lastName = JOptionPane.showInputDialog(null,"Ingresa el apellido del cliente.");
        String email = JOptionPane.showInputDialog(null,"Ingresa el email del cliente.");
        instaceModel().insertarCliente(new EntityCliente(name, lastName, email));
    }

    public static ModelCliente instaceModel(){
        return new ModelCliente();
    }

//    getAll

    public static  void listar(){

        String list = listar(instaceModel().encontrarCliente());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String listar(List<Object> listado){
        String lista = "Listado de los clientes";

        for (Object obj : listado){
            EntityCliente objModelos = (EntityCliente) obj;

            lista += objModelos.toString() + "\n";
        }
        return lista;
    }

    public static void borrar(){
        Object[] options = Util.listArray(instaceModel().encontrarCliente());

        EntityCliente objSelected = (EntityCliente) JOptionPane.showInputDialog(null, "selecciona una cliente","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);

        instaceModel().eliminarCliente(objSelected);
    }

    public static void update(){
        Object[] options = Util.listArray(instaceModel().encontrarCliente());
        EntityCliente objSelecto = (EntityCliente) JOptionPane.showInputDialog(null, "selecciona una cliente para actualizar","",JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
        objSelecto.setNombre_Cliente(JOptionPane.showInputDialog(null, "Ingresa el nuevo nombre del cliente: ", objSelecto.getNombre_Cliente()));
        objSelecto.setApellido(JOptionPane.showInputDialog(null, "Ingresa el nuevo apellido del cliente: ",objSelecto.getApellido()));
        objSelecto.setEmail(JOptionPane.showInputDialog(null, "Ingresa el nuevo email del cliente: ",objSelecto.getEmail()));
        instaceModel().actualizarCliente(objSelecto);
    }

}
