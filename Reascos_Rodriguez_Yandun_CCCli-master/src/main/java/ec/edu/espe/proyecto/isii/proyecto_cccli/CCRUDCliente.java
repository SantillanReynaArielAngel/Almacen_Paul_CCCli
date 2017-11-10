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
public class CCRUDCliente {
    Conexion coneccion;
    PreparedStatement sentencia;
    ResultSet resul;
    Connection cone;
    
    public CCRUDCliente() {
        coneccion = new Conexion();
    }
    public String GuardarCliente(String ced, String apeP, String apeM,String nom,String telF,String telC,String dir,String cor) {
        String mensaje = null;
        cone = coneccion.getConnection();
        try {
            String x = "INSERT INTO Cliente VALUES ('"+ced+"','"+apeP+"','"+apeM+"','"+nom+"','"+telF+"','"+telC+"','"+dir+"','"+cor+"')";
            sentencia = cone.prepareStatement(x);
            int numeroRegistro = sentencia.executeUpdate();
            if (numeroRegistro > 0) {
                mensaje = "Cliente ingresado";
            } else {
                mensaje = "Error al ingresar";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }
    public String[] BuscarCliente(String ced) {
        int bandera1 = 0;
        String valores[] = new String[8];
        for (int i = 0; i < 8; i++) {
            valores[i] = "";
        }
        cone = coneccion.getConnection();
        try {
            String x = "SELECT * FROM Cliente  WHERE cli_CEDULA='" + ced + "'";
            sentencia = cone.prepareStatement(x);
            resul = sentencia.executeQuery();//ejecuta la sentencia
            while (resul.next()) {
                valores[0] = resul.getString(1);
                valores[1] = resul.getString(2);
                valores[2] = resul.getString(3);
                valores[3] = resul.getString(4);
                valores[4] = resul.getString(5);
                valores[5] = resul.getString(6);
                valores[6] = resul.getString(7);
                valores[7] = resul.getString(8);
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
    public String ModificarCliente(String ced, String apeP, String apeM,String nom,String telF,String telC,String dir,String cor) {
        String mensaje = null;
        cone = coneccion.getConnection();
        try {
            String x = "UPDATE Cliente SET cli_Apellido_Paterno='"+apeP+"', cli_Apellido_Materno='"+apeM+"', cli_Nombres='"+nom+"', cli_TelFijo='"+telF+"', cli_TelCelular='"+telC+"', cli_Direccion='"+dir+"', cli_Correo='"+cor+"' WHERE cli_Cedula='"+ced+"'";
            sentencia = cone.prepareStatement(x);
            int numeroRegistro = sentencia.executeUpdate();
            if (numeroRegistro > 0) {
                mensaje = "Cliente modificado";
            } else {
                mensaje = "Error al modificar";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }
    
    public String EliminarCliente(String ced) {
        String mensaje = null;
        cone = coneccion.getConnection();
        try {
            String x = "DELETE FROM Cliente WHERE cli_Cedula='"+ced+"'";
            sentencia = cone.prepareStatement(x);
            int numeroRegistro = sentencia.executeUpdate();
            if (numeroRegistro > 0) {
                mensaje = "Cliente eliminado";
            } else {
                mensaje = "Error al eliminar";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }
}
