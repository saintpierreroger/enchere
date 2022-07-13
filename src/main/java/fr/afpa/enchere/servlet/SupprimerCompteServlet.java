package fr.afpa.enchere.servlet;

import fr.afpa.enchere.bo.Utilisateurs;
import fr.afpa.enchere.dal.ArticleSQL;
import fr.afpa.enchere.dal.RequeteSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/supprimerCompte")
public class SupprimerCompteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilisation de la session
        HttpSession session = request.getSession();
        // Utilisation de la dal
        RequeteSQL requeteSQL = new RequeteSQL();
        ArticleSQL articleSQL = new ArticleSQL();
        // Récupération du no_utilisateur en session
        int id = (int) session.getAttribute("id");
        // Utilisation des méthodes SQL, ⚠ à cause de la FK si on ne supprime pas l'article avant l'utilisateur ce dernier ne sera pas supprimer
        articleSQL.deleteArticle(id);
        requeteSQL.supprimerCompte(id);
        System.out.println("le compte est delete");
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);


    }
}