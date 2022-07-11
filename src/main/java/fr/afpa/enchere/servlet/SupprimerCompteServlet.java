package fr.afpa.enchere.servlet;

import fr.afpa.enchere.bo.Utilisateurs;
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
        request.getRequestDispatcher("").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("verifconnection", true);

        RequeteSQL supprimerCompte = new RequeteSQL();
        RequeteSQL userEnBDD = new RequeteSQL();

        String motDePasse = request.getParameter("motDepasse");
        String pseudo = request.getParameter("pseudo");
        Utilisateurs user = new Utilisateurs(pseudo, motDePasse);
        if (Integer.parseInt(session.getId()) == userEnBDD.idUtilisateur(user)) {
            supprimerCompte.supprimerCompte(user);
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }
    }
}