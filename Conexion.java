
package Utilidades;

import java.sql.*;

public class Conexion {
  
    private static Connection con;
   
    public static Connection conexion(){
        try {
            con = DriverManager.getConnection(Constantes.URL, Constantes.USER, Constantes.PASSWORD);
            return con;
        } catch (SQLException e) {
            Constantes.MENSAJE = e.getMessage();
            return null;
        }
    }
    
    public static Connection conexionp(){
        try {
            con = DriverManager.getConnection(Constantes.URLPOS, Constantes.USERPOS, Constantes.PASSWORDPOS);
            return con;
        } catch (SQLException e) {
            Constantes.MENSAJE = e.getMessage();
            return null;
        }
    }
    public static Connection conexionli(){
       try {
           
        // Imprimir mensaje de depuración
        System.out.println("Intentando establecer conexión a la base de datos...");

        // Establecer la conexión
        con = DriverManager.getConnection(Constantes.URLLITE);

        // Imprimir mensaje de depuración si la conexión fue exitosa
        System.out.println("Conexión establecida correctamente.");

        return con;
    }catch (SQLException e) {
        // Imprimir mensaje de error si hay una excepción
        System.out.println("Error al establecer la conexión a la base de datos:");
        e.printStackTrace(); // Imprimir el stack trace para obtener más detalles del error

        Constantes.MENSAJE = e.getMessage();
        return null;
    }
//try {
//            con = DriverManager.getConnection(Constantes.URLLITE);
//            return con;
//        } catch (SQLException e) {
//            Constantes.MENSAJE = e.getMessage();
//            return null;
//        }
//    
    }
    public static Connection conexionorc(){
//        try {
//            con = DriverManager.getConnection(Constantes.URLORC, Constantes.USERORC, Constantes.PASSWORDORC);
//            return con;
//        } catch (SQLException e) {
//            Constantes.MENSAJE = e.getMessage();
//            return null;
//        }
//    }
     try {
           
        // Imprimir mensaje de depuración
        System.out.println("Intentando establecer conexión a la base de datos...");

        // Establecer la conexión
        con = DriverManager.getConnection(Constantes.URLORC, Constantes.USERORC, Constantes.PASSWORDORC);

        // Imprimir mensaje de depuración si la conexión fue exitosa
        System.out.println("Conexión establecida correctamente.");

        return con;
    }catch (SQLException e) {
        // Imprimir mensaje de error si hay una excepción
        System.out.println("Error al establecer la conexión a la base de datos:");
        e.printStackTrace(); // Imprimir el stack trace para obtener más detalles del error

        Constantes.MENSAJE = e.getMessage();
        return null;
    }

    }}
