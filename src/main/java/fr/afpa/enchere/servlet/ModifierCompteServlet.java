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


@WebServlet("/modifierCompte")
public class ModifierCompteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/modifierProfil.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequeteSQL modifierProfil = new RequeteSQL();
        Utilisateurs user = new Utilisateurs();
        int id = (int) session.getAttribute("id");
        String pseudo = request.getParameter("pseudo");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("mail");
        String telephone = request.getParameter("tel");
        String rue = request.getParameter("rue");
        String ville = request.getParameter("ville");
        String codePostal = request.getParameter("codepostal");
        String newPassword = request.getParameter("newpassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");
        user = new Utilisateurs(id, pseudo, prenom, nom, email, telephone, rue, ville, codePostal, newPassword);
        modifierProfil.modifierProfil(id, pseudo, prenom, nom, email, telephone, rue, ville, codePostal, newPassword);
        request.setAttribute("utilisateur", user);
        request.getRequestDispatcher("WEB-INF/profilClientModifier.jsp").forward(request, response);
    }
}

