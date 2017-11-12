/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.proyecto.isii.proyecto_cccli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ivan
 */
public class CCRUDProducto {
    
    Conexion coneccion;
    PreparedStatement sentencia;
    ResultSet resul;
    Connection cone;

    public CCRUDProducto() {
        coneccion = new Conexion();
    }
    public String GuardarProducto(String cod, String ser, String mar,String pre,String des,String sto) {
        String mensaje = null;
        cone = coneccion.getConnection();
        try {
            String x = "INSERT INTO Producto VALUES ('"+cod+"','"+ser+"','"+mar+"','"+pre+"','"+des+"','"+sto+"')";
            sentencia = cone.prepareStatement(x);
            int numeroRegistro = sentencia.executeUpdate();
            if (numeroRegistro > 0) {
                mensaje = "Producto ingresado";
            } else {
                mensaje = "Error al ingresar";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }
    
    public String[] BuscarProducto(String cod) {
        int bandera1 = 0;
        String valores[] = new String[6];
        for (int i = 0; i < 6; i++) {
            valores[i] = "";
        }
        cone = coneccion.getConnection();
        try {
            String x = "SELECT * FROM Producto  WHERE pro_Codigo='" + cod + "'";
            sentencia = cone.prepareStatement(x);
            resul = sentencia.executeQuery();//ejecuta la sentencia
            while (resul.next()) {
                valores[0] = resul.getString(1);
                valores[1] = resul.getString(2);
                valores[2] = resul.getString(3);
                valores[3] = resul.getString(4);
                valores[4] = resul.getString(5);
                valores[5] = resul.getString(6);
                bandera1++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (bandera1 == 0) {
            valores[0] = String.valueOf(-1);
        }
        return valores;
    }
    public String ModificarProducto(String cod, String ser, String mar,String pre,String des,String sto) {
        String mensaje = null;
        cone = coneccion.getConnection();
        try {
            String x = "UPDATE Producto SET pro_Serie='"+ser+"', pro_Marca='"+mar+"', pro_Precio='"+pre+"', pro_Descripcion='"+des+"', pro_Stock='"+sto+"' WHERE pro_Codigo='"+cod+"'";
            sentencia = cone.prepareStatement(x);
            int numeroRegistro = sentencia.executeUpdate();
            if (numeroRegistro > 0) {
                mensaje = "Producto modificado";
            } else {
                mensaje = "Error al modificar";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }
    
    public String EliminarProducto(String cod) {
        String mensaje = null;
        cone = coneccion.getConnection();
        try {
            String x = "DELETE FROM Producto WHERE pro_Codigo='"+cod+"'";
            sentencia = cone.prepareStatement(x);
            int numeroRegistro = sentencia.executeUpdate();
            if (numeroRegistro > 0) {
                mensaje = "Producto eliminado";
            } else {
                mensaje = "Error al eliminar";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }
    
}
