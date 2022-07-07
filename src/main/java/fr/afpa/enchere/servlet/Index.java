package fr.afpa.enchere.servlet;

import fr.afpa.enchere.dal.ArticleSQL;
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
        ArticleSQL articleSQL = new ArticleSQL();
        // Selection des Articles en enchère
        request.setAttribute("articles", articleSQL.selectAll1());
        // Envoi à index.jsp
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilisation de la DAL
        ArticleSQL articleSQL = new ArticleSQL();
        // Recherche d'un article par son nom mais pas affichage pour l'instant
        request.setAttribute("articles", articleSQL.selectByNomCategorie("name"));
        // Envoi à index.jsp
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

    }
}
