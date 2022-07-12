package fr.afpa.enchere.servlet;

import fr.afpa.enchere.bo.Utilisateurs;
import fr.afpa.enchere.dal.RequeteSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ProfilVendeur")
public class ProfilVendeur extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequeteSQL afficherProfil = new RequeteSQL();
        int id = Integer.parseInt(request.getParameter("id"));
        Utilisateurs utilisateurs = afficherProfil.profilUtilisateur(id);
        request.setAttribute("utilisateurs", utilisateurs);
        request.getRequestDispatcher("WEB-INF/profilVendeur.jsp").forward(request, response);
    }
}
