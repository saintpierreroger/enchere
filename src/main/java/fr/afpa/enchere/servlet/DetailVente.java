package fr.afpa.enchere.servlet;

import fr.afpa.enchere.dal.DetailVenteSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DetailVente")
public class DetailVente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilisation de la dal
        DetailVenteSQL detailVenteSQL = new DetailVenteSQL();
        // création de la variable id dans laquelle je met le no_article
        int id = Integer.parseInt(request.getParameter("idArticle"));
        // Selection des détails de la vente (dans différentes tables ==> inner join cf. DetailVenteSQL.java)
        request.setAttribute("detailsVente", detailVenteSQL.select_article(id));
        // Envoi à detailVente.jsp pour affichage
        request.getRequestDispatcher("WEB-INF/detailVente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilisation de la dal
        DetailVenteSQL detailVenteSQL = new DetailVenteSQL();
        // création de la variable id dans laquelle je met le no_article
        int id = Integer.parseInt(request.getParameter("idArticle"));
        // Selection des détails de la vente (dans différentes tables ==> inner join cf. DetailVenteSQL.java)
        request.setAttribute("detailsVente", detailVenteSQL.select_article(id));
        // Envoi à detailVente.jsp pour affichage
        request.getRequestDispatcher("WEB-INF/detailVente.jsp").forward(request, response);

    }
}
