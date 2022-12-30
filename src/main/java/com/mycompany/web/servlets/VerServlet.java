package com.mycompany.web.servlets;

import java.io.IOException;

import com.mycompany.web.models.Accionesdatos;
import com.mycompany.web.models.Datos;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verDatos")
public class VerServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   int i = Integer.parseInt(req.getParameter("Id"));

   Datos registro = Accionesdatos.verDatos(i);

   req.setAttribute("d", registro);

RequestDispatcher respuesta = req.getRequestDispatcher("/infodatos.jsp");
   respuesta.forward(req,resp);
}
}
