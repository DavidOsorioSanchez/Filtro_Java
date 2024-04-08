package Model;

import Database.CRUDTienda;
import Database.ConfigDB;
import Entity.EntityTienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModelTienda implements CRUDTienda {
    @Override
    public List<Object> listarTiendas() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listarTienda = new ArrayList<>();

        try {

            String SQL = "SELECT * FROM Tienda ORDER BY Tienda.id_Tienda ASC;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {

                EntityTienda objMolde = new EntityTienda();

                objMolde.setID_Tienda(objResult.getInt("id_Tienda"));
                objMolde.setNombreTienda(objResult.getString("nombreTienda"));
                objMolde.setUbicacion(objResult.getString("ubicacion"));

                listarTienda.add(objMolde);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ಠ_ಠ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listarTienda;
    }
}
