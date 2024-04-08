package Model;

import Database.CRUDProducto;
import Database.ConfigDB;
import Entity.EntityProducto;
import Entity.EntityTienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModelProducto implements CRUDProducto {
    @Override
    public Object insertarProducto(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityProducto objMolde = (EntityProducto) object;

        try {
            String SQL = "INSERT INTO Producto(nombreProducto, precio, stock, FK_id_Tienda) VALUES(?,?,?,?);";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objMolde.getNombreProducto());
            objPrepare.setDouble(2, objMolde.getPrecio());
            objPrepare.setInt(3,objMolde.getStock());
            objPrepare.setInt(4,objMolde.getFK_Id_Tienda());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()){
                objMolde.setID_Producto(objResult.getInt(1));
            }

            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Se a podido añadir el producto. (・∀・ )");

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "(╯°□°）╯︵ ┻━┻ ha sucedido un error: " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objMolde;
    }

    @Override
    public boolean actualizarProducto(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityProducto objmolde = (EntityProducto)object;

        boolean isUpdated=false;

        try {

            String SQL  = "UPDATE Producto SET nombreProducto = ?, precio = ?, stock = ?, FK_id_Tienda = ? WHERE id_Producto = ?";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL,PreparedStatement.RETURN_GENERATED_KEYS);


            objPrepare.setString(1,objmolde.getNombreProducto());
            objPrepare.setDouble(2,objmolde.getPrecio());
            objPrepare.setInt(3,objmolde.getStock());
            objPrepare.setInt(4,objmolde.getFK_Id_Tienda());
            objPrepare.setInt(5,objmolde.getID_Producto());

            int lineasAfectadas  = objPrepare.executeUpdate();
            if (lineasAfectadas > 0){

                isUpdated= true;
                JOptionPane.showMessageDialog(null,"la actualizacion fue llevada a cabo exitosamente. Ｏ(≧∇≦)Ｏ");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"ノ┬─┬ノ ︵ ( =o°o)=  Error raro: " + e.getMessage());
        }finally {

            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    @Override
    public boolean eliminarProducto(Object object) {
        Connection objConnection = ConfigDB.openConnection();

        EntityProducto objMolde = (EntityProducto) object;

        boolean isDeleted = false;

        try {

            String SQL = "DELETE FROM Producto WHERE id_Producto = ?;";


            PreparedStatement objPrepare = objConnection.prepareStatement(SQL);


            objPrepare.setInt(1, objMolde.getID_Producto());

            int totalAfectado = objPrepare.executeUpdate();

            if (totalAfectado>0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Se a eliminado efectivamente. (☞ﾟヮﾟ)☞");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ಥ_ಥ Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }

    @Override
    public List<Object> encontrarProductoTienda() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listaProducto = new ArrayList<>();
        try {

            String SQL = "SELECT * FROM Producto INNER JOIN Tienda ON Producto.FK_id_Tienda = Tienda.id_Tienda ORDER BY Tienda.nombreTienda ASC;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while (objResult.next()){
                EntityProducto objMolde = new EntityProducto();
                EntityTienda objTienda = new EntityTienda();

                objMolde.setNombreProducto(objResult.getString("Producto.nombreProducto"));
                objMolde.setPrecio(objResult.getDouble("Producto.precio"));
                objMolde.setStock(objResult.getInt("Producto.stock"));
                objMolde.setFK_Id_Tienda(objResult.getInt("Producto.FK_id_Tienda"));

                objTienda.setID_Tienda(objResult.getInt("Tienda.id_Tienda"));
                objTienda.setNombreTienda(objResult.getString("Tienda.nombreTienda"));
                objTienda.setUbicacion(objResult.getString("Tienda.ubicacion"));

                objMolde.getEntidadTienda(objTienda);

                listaProducto.add(objMolde);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"T_T Se a presentado un error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaProducto;
    }

    @Override
    public List<Object> encontrarProductoNombre() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listaProducto = new ArrayList<>();
        try {

            String SQL = "SELECT * FROM Producto INNER JOIN Tienda ON Producto.FK_id_Tienda = Tienda.id_Tienda ORDER BY Producto.nombreProducto ASC;";

            PreparedStatement objPrepare = objConnection.prepareStatement(SQL);

            ResultSet objResult = (ResultSet) objPrepare.executeQuery();

            while (objResult.next()){
                EntityProducto objMolde = new EntityProducto();
                EntityTienda objTienda = new EntityTienda();

                objMolde.setNombreProducto(objResult.getString("Producto.nombreProducto"));
                objMolde.setPrecio(objResult.getDouble("Producto.precio"));
                objMolde.setStock(objResult.getInt("Producto.stock"));
                objMolde.setFK_Id_Tienda(objResult.getInt("Producto.FK_id_Tienda"));

                objTienda.setID_Tienda(objResult.getInt("Tienda.id_Tienda"));
                objTienda.setNombreTienda(objResult.getString("Tienda.nombreTienda"));
                objTienda.setUbicacion(objResult.getString("Tienda.ubicacion"));

                objMolde.getEntidadTienda(objTienda);

                listaProducto.add(objMolde);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"(ʘ言ʘ╬) Se a presentado un error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaProducto;
    }


}
