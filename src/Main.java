import Controller.ClienteController;
import Controller.ProductoController;
import Database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int option1 = 0, option2 = 0, option3 = 0;

        do {
            option1 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    1. Administrar Cliente
                    2. Administrar Producto
                    3. Salir
                    
                    Eligue la opcion que mas te conviene.
                    """));
            switch (option1){
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Añadir informacion a cliente
                                2. Modificar cliente
                                3. Borrar cliente
                                4. Listar cliente
                                5. Salir 
                                
                                Elige la opcion que mas te conviene.
                                """));
                        switch (option2){
                            case 1:
                                ClienteController.insert();
                                break;
                            case 2:
                                ClienteController.update();
                                break;
                            case 3:
                                ClienteController.borrar();
                                break;
                            case 4:
                                ClienteController.listar();
                                break;
                        }
                    }while (option2 != 5);

                    break;
                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                1. Añadir Producto
                                2. Modificar Producto
                                3. Borrar Producto
                                4. Listar Producto
                                5. Salir

                                Elige la opcion que mas te conviene.
                                """));
                        switch (option2){
                            case 1:
                                ProductoController.insert();
                                break;
                            case 2:
                                ProductoController.update();
                                break;
                            case 3:
                                ProductoController.borrar();
                                break;
                            case 4:
                                do {
                                    option3 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                            1. Listar por Nombre.
                                            2. Listar por tienda.
                                            3. Salir.
                                            """));
                                    switch (option3){
                                        case 1:
                                            ProductoController.listarNombre();
                                            break;
                                        case 2:
                                            ProductoController.listarTienda();
                                            break;
                                    }
                                }while (option3 != 3);
                                break;
                        }
                    }while (option2 != 5);
                    break;
//                case 3:
//                    do {
//                        option2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
//                                1. Añadir informacion a Cita
//                                2. Modificar Cita
//                                3. Borrar Cita
//                                4. Listar una cita por fecha
//                                5. Salir
//
//                                Elige la opcion que mas te conviene.
//                                """));
//                        switch (option2){
//                            case 1:
//                                CitaController.insert();
//                                break;
//                            case 2:
//                                CitaController.update();
//                                break;
//                            case 3:
//                                CitaController.borrar();
//                                break;
//                            case 4:
//                                CitaController.listar();
//                                break;
//                        }
//                    }while (option2 != 5);
//                    break;
            }
        }while (option1 != 3);


    }
}