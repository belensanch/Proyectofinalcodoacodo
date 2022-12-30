package com.mycompany.web.models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class Accionesdatos {
public static int registrarDatos(Datos d){
    int estado = 0;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); //OJO!!!EN CADA CONECCION DEBEREMOS CARGAR LA CLASE PRIMERO PARA PODER IDENTIFICAR AL DRIVER Y CONECTARNOS A LA BBDD
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/usuarios","root","");

        String query = "INSERT INTO datos(Nombre,Apellido,Contacto) VALUES (?,?,?)";

        String nombre = d.getNombre();
        String apellido = d.getApellido();
        String contacto = d.getContacto();

       System.out.println(nombre);
       System.out.println(apellido);
       System.out.println(contacto);
       

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, contacto);

        estado = pst.executeUpdate();

        conexion.close();

    

    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return estado;
}

//actualizar registro

public static int actualizardatos(Datos d){
    int estado = 0;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/usuarios","root","");

        String query = "UPDATE datos SET Nombre=?,Apellido=?,Contacto=? WHERE Id=?";

        int id = d.getId();
        String nombre = d.getNombre();
        String apellido = d.getApellido();
        String contacto = d.getContacto();

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, nombre);
        pst.setString(2, apellido);
        pst.setString(3, contacto);
        pst.setInt(4, id);

        estado = pst.executeUpdate();

        conexion.close();


    } catch (Exception e){
        System.out.println("uppsss algo salio mal");
    }

    return estado;
}

//consultar registro por id

/**
 * @param IdAConsultar
 * @return
 */
public static Datos verDatos(int IdAConsultar){
    Datos datosADevolver = new Datos();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/usuarios","root","");

        String query = "SELECT * FROM datos WHERE Id=?";

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setInt(1, IdAConsultar);

        ResultSet consultaDatos = pst.executeQuery();

        if (consultaDatos.next()){
           datosADevolver.setId( consultaDatos.getInt(1));
            datosADevolver.setNombre( consultaDatos.getString(2));
            datosADevolver.setApellido(consultaDatos.getString(3));
            datosADevolver.setContacto( consultaDatos.getString(4));
            conexion.close();
        }
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return datosADevolver;
}    

//consultar todos los registros de una tabla

/**
 * @return
 */
public static List<Datos> verTodosDatos(){
    List<Datos> listaDatosADevolver = new ArrayList<Datos>();
    

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/usuarios","root","");

        String query = "SELECT * FROM datos";

        PreparedStatement pst = conexion.prepareStatement(query);

        ResultSet consultaDatos = pst.executeQuery();

        while (consultaDatos.next()){
            Datos datosADevolver = new Datos(); //EN CADA VUELTA NECESITAREMOS INSTANCIAR UN NUEVO OBJETO
           datosADevolver.setId( consultaDatos.getInt(1));
            datosADevolver.setNombre( consultaDatos.getString(2));
            datosADevolver.setApellido( consultaDatos.getString(3));
            datosADevolver.setContacto( consultaDatos.getString(4));
            listaDatosADevolver.add(datosADevolver);
        }
        conexion.close();
    } catch (Exception e){
        System.out.println(e);
        System.out.println("uppsss algo salio mal");
    }

    return listaDatosADevolver;
} 
    
}
