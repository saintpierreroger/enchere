package fr.afpa.enchere.servlet;

import fr.afpa.enchere.dal.RequeteSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/lostpassword")
public class LostPassWordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/reinitMDP.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequeteSQL passeWordLost = new RequeteSQL();
        String newPassWord = request.getParameter("lostPW");
        String confirmation = request.getParameter("confirmLostPW");
        String pseudo = request.getParameter("username");
        String mail = request.getParameter("mail");
        if (newPassWord.equals(confirmation)) {
            passeWordLost.updateMDPlost(mail, pseudo, newPassWord);
        }
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}