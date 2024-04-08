package Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/Filtro_De_Java";
            String user = "root";
            String password = "Rlwl2023.";

            objConnection = (Connection) DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error >> Driver no Instalado");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error >> No se pudo establecer una conexión con la BD"+e.getMessage());
        }

        return objConnection;

    }


    public static void closeConnection(){
        try {
            if (objConnection != null) objConnection.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR: "+ e.getMessage());
        }
    }
}
