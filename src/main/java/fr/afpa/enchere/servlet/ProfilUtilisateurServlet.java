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


@WebServlet("/profilutilisateur")
public class ProfilUtilisateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("verifconnection", true);

        RequeteSQL afficherProfil = new RequeteSQL();
        System.out.println(session.getAttribute("id"));
        Utilisateurs utilisateurs = afficherProfil.profilUtilisateur((Integer) session.getAttribute("id"));
        request.setAttribute("utilisateurs", utilisateurs);

        request.getRequestDispatcher("WEB-INF/profilClient.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}