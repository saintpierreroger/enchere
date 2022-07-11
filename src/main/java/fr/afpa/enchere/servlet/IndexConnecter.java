package fr.afpa.enchere.servlet;

import fr.afpa.enchere.bo.UtilisateursArticles_Vendus;
import fr.afpa.enchere.dal.ArticleSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/indexConnecter")
public class IndexConnecter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilisation de la DAL
        ArticleSQL articleSQL = new ArticleSQL();
        // Selection des Articles en enchère
        request.setAttribute("articles", articleSQL.selectAll1());
        request.getRequestDispatcher("WEB-INF/indexConnecter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilisation de la DAL
        ArticleSQL articleSQL = new ArticleSQL();
        List<UtilisateursArticles_Vendus> articles = articleSQL.selectByNomArticleEtNoCategorie(
                request.getParameter("name"),
                Integer.parseInt(request.getParameter("no_categorie")));
        // Récupération des parametres de la jsp nom de l'article et numéro de catégorie
        String name = request.getParameter("name");
        String filter = request.getParameter("no_categorie");
        // affichage de la recherche
        request.setAttribute("articles", articles);
        // Envoi à indexConnecter.jsp
        request.getRequestDispatcher("WEB-INF/indexConnecter.jsp").forward(request, response);

    }
}
