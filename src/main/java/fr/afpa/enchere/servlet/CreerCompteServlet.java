package fr.afpa.enchere.servlet;

import fr.afpa.enchere.dal.RequeteSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

///Servlet qui utilise la methode insert pour creer un utilisateur
@WebServlet("/compteServlet")
public class CreerCompteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/creationCompte.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequeteSQL newCompte = new RequeteSQL();
        String pseudoUtilisateur = request.getParameter("pseudo");
        String nomUtilisateur = request.getParameter("nom");
        String prenomUtilisateur = request.getParameter("prenom");
        String mailUtilisateur = request.getParameter("mail");
        String telUtilisateur = request.getParameter("tel");
        String rue = request.getParameter("rue");
        int codePostal = Integer.parseInt(request.getParameter("codepostal"));
        String ville = request.getParameter("ville");
        String passWord = request.getParameter("password");
        String confirmPassWord = request.getParameter("confirm");
        newCompte.insertCreaCompteSQL(pseudoUtilisateur, nomUtilisateur, prenomUtilisateur, mailUtilisateur, telUtilisateur, rue, codePostal, ville, passWord, confirmPassWord);
        if (passWord.equals(confirmPassWord)) {
            //changer vers la page d'acceuille connected
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        }
    }
}