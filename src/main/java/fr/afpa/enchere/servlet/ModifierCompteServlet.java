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
        session.setAttribute("verifconnection", true);
        Utilisateurs utilisateurs = modifierProfil.profilUtilisateur((Integer) session.getAttribute("id"));
        request.setAttribute("utilisateurs", utilisateurs);

        String pseudo = request.getParameter("pseudo");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String ville = request.getParameter("ville");
        String codePostal = request.getParameter("codePostal");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");


        Utilisateurs user = new Utilisateurs(pseudo, prenom, nom, email, telephone, rue, codePostal, ville);
        System.out.println(user);
        modifierProfil.modifierProfil(user);
        request.getRequestDispatcher("WEB-INF/profilClient.jsp").forward(request, response);


    }

}

