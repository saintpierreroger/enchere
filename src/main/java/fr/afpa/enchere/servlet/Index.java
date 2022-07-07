package fr.afpa.enchere.servlet;

import fr.afpa.enchere.dal.EnchereSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/index")
public class Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilisation de la DAL
        EnchereSQL enchereSQL = new EnchereSQL();
        // Selection de toutes les enchères en BDD
        request.setAttribute("encheres", enchereSQL.selectAll());
        // Envoi à index.jsp
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
