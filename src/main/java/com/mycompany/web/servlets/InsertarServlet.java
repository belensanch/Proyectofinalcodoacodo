package com.mycompany.web.servlets;

import java.io.IOException;

import com.mycompany.web.models.Accionesdatos;
import com.mycompany.web.models.Datos;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nuevoDato")
public class InsertarServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n , a, c;

        n = req.getParameter("Nombre");

        a = req.getParameter("Apellido");

        c = req.getParameter("Contacto");

        Datos nuevoDato = new Datos();

    
        nuevoDato.setNombre(n);
        nuevoDato.setApellido(a);
        nuevoDato.setContacto(c);

        int estado = Accionesdatos.registrarDatos(nuevoDato);

        if (estado == 1){
            resp.sendRedirect("exito.jsp");
            System.out.println("todo ok");
        } else {
            System.out.println("Error");
            resp.sendRedirect("error.jsp");
        }



    }
}
