package fr.afpa.enchere.servlet;


import fr.afpa.enchere.bo.UtilisateursArticles_Vendus;
import fr.afpa.enchere.dal.ArticleSQL;
import fr.afpa.enchere.bo.Utilisateurs;
import fr.afpa.enchere.dal.RequeteSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;


@WebServlet("/connexionservlet")
public class ConnexionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

// Je redirige vers la page index.jsp
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")) {
                request.setAttribute("login", cookie.getValue());
            }
        }
        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequeteSQL connection = new RequeteSQL();
        String pseudoUser = request.getParameter("username");
        String passewordUser = request.getParameter("password");
        int idUtilisateur = connection.id(pseudoUser);
        boolean connexion = connection.connexionSQL(pseudoUser, passewordUser);

        String check = request.getParameter("box");
        if (check != null) {
            Cookie connexionCookie = new Cookie("login", pseudoUser);
            response.addCookie(connexionCookie);
        }
        if (connexion) {
            HttpSession session = request.getSession();
            session.setAttribute("verifconnection", true);
            session.setAttribute("id", idUtilisateur);
            System.out.println(session.getAttribute("verifconnection"));
            // Utilisation de la DAL
            ArticleSQL articleSQL = new ArticleSQL();
            // Selection des Articles en enchère
            request.setAttribute("articles", articleSQL.selectAll1());
            request.getRequestDispatcher("WEB-INF/indexConnecter.jsp").forward(request, response);
        } else {

            request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);

        }

    }

}
