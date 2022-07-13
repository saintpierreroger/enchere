package fr.afpa.enchere.servlet;

import fr.afpa.enchere.dal.DetailVenteSQL;
import fr.afpa.enchere.dal.EnchereSQL;
import fr.afpa.enchere.dal.RetraitSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/DetailVente")
public class DetailVente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilisation de la session
        HttpSession session = request.getSession();
        // Utilisation du no_utilisateur stocké en session
        request.setAttribute("noUtilisateur", session.getAttribute("id"));
        // Utilisation de la dal
        DetailVenteSQL detailVenteSQL = new DetailVenteSQL();
        RetraitSQL retraitSQL = new RetraitSQL();
        // création de la variable id dans laquelle je met le no_article (idArticle vient des liens des noms d'article
        //d'index.jsp et indexConnecter
        int id = Integer.parseInt(request.getParameter("idArticle"));
        // Selection des détails de la vente (dans différentes tables ==> inner join cf. DetailVenteSQL.java)
        request.setAttribute("detailsVente", detailVenteSQL.select_article(id));
        // Selection de l'adresse
        request.setAttribute("adresse", retraitSQL.select_all(id));
        // Envoi à detailVente.jsp pour affichage
        request.getRequestDispatcher("WEB-INF/detailVente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilisation de la dal
        EnchereSQL enchereSQL = new EnchereSQL();
        // Utilisation de la session
        HttpSession session = request.getSession();
        // Utilisation du no_utilisateur stocké en session
        request.setAttribute("noUtilisateur", session.getAttribute("id"));
        // Récupération des paramètres nécaissaires se trouvant sur detailVente.jsp
        int no_article = Integer.parseInt(request.getParameter("idArticle"));
        String date_enchere = request.getParameter("date_enchere");
        int montant_enchere = Integer.parseInt(request.getParameter("montant_enchere"));
        // On change le type de date_enchere de String en date
        Date dateAInserer = Date.valueOf(date_enchere);
        // On change l'id (le no_utilisateur) de string en int
        int no_utilisateur = Integer.parseInt("id");
        // Insert en BDD de l'enchère quand la personne clique sur enchérir
        enchereSQL.insertEnchere(no_utilisateur, no_article, dateAInserer, montant_enchere);

    }
}
