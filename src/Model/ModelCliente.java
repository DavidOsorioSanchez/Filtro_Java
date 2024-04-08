package Model;

import Database.CRUDCliente;
import Database.ConfigDB;
import Entity.EntityCliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModelCliente implements CRUDCliente {

    @Override
    public Object insertarCliente(Object object) {
        Connection objConnection = ConfigDB.openConnection();
        EntityCliente objMolde = (EntityCliente) object;
        try {
            String SQL = "INSERT INTO Cliente(nombreCliente, apellido, email) VALUES(?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1,objMolde.getNombre_Cliente());
            objPrepare.setString(2,objMolde.getApellido());
            objPrepare.setString(3,objMolde.getEmail());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objMolde.setID_Cliente(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null, "ᕕ( ᐛ )ᕗ se a añadido cliente!!");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ಠ_ಠ Han surgido errores: " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objMolde;
    }

    @Override
    public boolean actualizarCliente(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityCliente objMolde = (EntityCliente)object;

        boolean isUpdated = false;

        try {

            String SQL  = "UPDATE Cliente SET nombreCliente = ?, apellido = ?, email = ? WHERE id_Cliente = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setString(1,objMolde.getNombre_Cliente());
            objPrepare.setString(2,objMolde.getApellido());
            objPrepare.setString(3,objMolde.getEmail());
            objPrepare.setInt(4,objMolde.getID_Cliente());


            int lineasAfectadas  = objPrepare.executeUpdate();

            if (lineasAfectadas > 0){

                isUpdated = true;
                JOptionPane.showMessageDialog(null,"La actualizacion a sido llevada a cabo con exito. ʕ•ᴥ•ʔ");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"(ง'̀-'́)ง  Error de sintaxis: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean eliminarCliente(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityCliente objMolde = (EntityCliente) object;

        boolean isDeleted = false;

        try {

            String SQL = "DELETE FROM Cliente WHERE  id_Cliente = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setInt(1, objMolde.getID_Cliente());

            int totalAfectado = objPrepare.executeUpdate();

            if (totalAfectado>0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Se a eliminado satisfactoriamente. ヽ(´▽`)/");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ಥ_ಥ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }

    @Override
    public List<Object> encontrarCliente() {
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listaCliente = new ArrayList<>();


        try {

            String SQL = "SELECT * FROM Cliente ORDER BY Cliente.nombreCliente ASC;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while (objResult.next()) {

                EntityCliente objModelos = new EntityCliente();

                objModelos.setID_Cliente(objResult.getInt("id_Cliente"));
                objModelos.setNombre_Cliente(objResult.getString("nombreCliente"));
                objModelos.setApellido(objResult.getString("apellido"));
                objModelos.setEmail(objResult.getString("email"));

                listaCliente.add(objModelos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ಠ_ಠ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return listaCliente;
    }
}
