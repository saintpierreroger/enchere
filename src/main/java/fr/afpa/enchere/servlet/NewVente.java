package fr.afpa.enchere.servlet;

import fr.afpa.enchere.dal.ArticleSQL;
import fr.afpa.enchere.dal.RequeteSQL;
import fr.afpa.enchere.dal.RetraitSQL;
import fr.afpa.enchere.dal.UtilisateurSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

@WebServlet("/NewVente")
public class NewVente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Appel de la session
        HttpSession session = request.getSession();
        // Utilisation de l'id stockée en session (donc de l'user connecté)
        int id = (int) session.getAttribute("id");
        // Utilisation de la DAL
        UtilisateurSQL utilisateurSQL = new UtilisateurSQL();
        // Selection de l'utilisateur en focntion de son ID et affichage de l'adresse
        request.setAttribute("adresse", utilisateurSQL.selectById(id));
        request.getRequestDispatcher("WEB-INF/newVente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Appel de la session
        HttpSession session = request.getSession();
        // Utilisation de l'id stockée en session (donc de l'user connecté)
        int id = (int) session.getAttribute("id");
        // Ici nous récupérons les paramètres en newVente.jsp pour pouvoir les insérer en BDD
        String nom_article = request.getParameter("nom_article");
        String description = request.getParameter("description");
        int no_categorie = Integer.parseInt(request.getParameter("no_categorie"));
        int prix_initial = Integer.parseInt(request.getParameter("prix_initial"));
        String date_debut_encheres = request.getParameter("date_debut_encheres");
        Date dateDebutEncheres = Date.valueOf(date_debut_encheres);
        String date_fin_encheres = request.getParameter("date_fin_encheres");
        Date dateFinEncheres = Date.valueOf(date_fin_encheres);
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("code_postal");
        String ville = request.getParameter("ville");
        // Utilisation de la dal
        ArticleSQL articleSQL = new ArticleSQL();
        RetraitSQL retraitSQL = new RetraitSQL();
        // Insertion en BDD des paramètres récupérés ci-dessus
        articleSQL.insertIntoArticles(nom_article, description, dateDebutEncheres, dateFinEncheres, prix_initial, id, no_categorie);
        int no_article = articleSQL.selectDernier();
        request.setAttribute("no_vente", no_article);
        retraitSQL.insertIntoRetraits(no_article, rue, codePostal, ville);
        request.getRequestDispatcher("WEB-INF/indexConnecter.jsp").forward(request, response);
    }
}
