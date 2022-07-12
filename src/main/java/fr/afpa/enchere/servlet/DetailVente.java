package fr.afpa.enchere.servlet;

import fr.afpa.enchere.bo.Utilisateurs;
import fr.afpa.enchere.dal.DetailVenteSQL;
import fr.afpa.enchere.dal.RetraitSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/DetailVente")
public class DetailVente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("noUtilisateur", session.getAttribute("id"));
        // Utilisation de la dal
        DetailVenteSQL detailVenteSQL = new DetailVenteSQL();
        RetraitSQL retraitSQL = new RetraitSQL();
        // création de la variable id dans laquelle je met le no_article
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


    }
}
