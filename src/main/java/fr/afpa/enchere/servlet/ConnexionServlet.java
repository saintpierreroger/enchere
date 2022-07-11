package fr.afpa.enchere.servlet;


import fr.afpa.enchere.dal.RequeteSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;


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
        boolean connexion = connection.connexionSQL(pseudoUser, passewordUser);

        String check = request.getParameter("box");
        if (check != null) {
            Cookie connexionCookie = new Cookie("login", pseudoUser);
            response.addCookie(connexionCookie);
        }
        if (connexion) {
            HttpSession session = request.getSession();
            session.setAttribute("verifconnection", true);
            System.out.println(session.getAttribute("verifconnection"));
            request.getRequestDispatcher("WEB-INF/indexConnecter.jsp").forward(request, response);
        } else {

            request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);

        }

    }

}
