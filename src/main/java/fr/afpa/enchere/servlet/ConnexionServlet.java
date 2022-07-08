package fr.afpa.enchere.servlet;

import fr.afpa.enchere.dal.RequeteSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/connexionservlet")
public class ConnexionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        connection.connexionSQL(pseudoUser, passewordUser);
        Cookie monCookie = new Cookie("login", pseudoUser);
        response.addCookie(monCookie);
        request.getRequestDispatcher("WEB-INF/connecter.jsp").forward(request, response);
    }

}
