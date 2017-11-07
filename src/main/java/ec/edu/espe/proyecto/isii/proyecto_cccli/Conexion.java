/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.proyecto.isii.proyecto_cccli;

/**
 *
 * @author DiegoYandun
 */
public class Conexion {
    private static java.sql.Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "12345";// Contraseña de la base
    private static final String url = "jdbc:mysql://localhost:3306/CCCli"; //Nombre de la base
    
}
