package fr.afpa.enchere.servlet;

import fr.afpa.enchere.dal.UtilisateurSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/NewVente")
public class NewVente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Appel de la session
        HttpSession session = request.getSession();
        // Utilisation de l'id stockée en session (donc de l'user connecté)
        int id = (int) session.getAttribute("id");
        // Utilisation de la DAL
        UtilisateurSQL utilisateurSQL = new UtilisateurSQL();
        // Selection de l'utilisateur en focntion de son ID et affichage de l'adresse
        request.setAttribute("adresse", utilisateurSQL.selectById(id));
        request.getRequestDispatcher("WEB-INF/newVente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String article = request.getParameter("article");
        String description = request.getParameter("description");
        String categorie = request.getParameter("categorie");
        int prix = Integer.parseInt(request.getParameter("miseAprix"));

        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String dateFin = request.getParameter("fin");
        String rue = request.getParameter("rue");
        int codePostal = Integer.parseInt(request.getParameter("codePostal"));
        String ville = request.getParameter("ville");

        request.setAttribute("article", article);
        request.setAttribute("description", description);
        request.setAttribute("categorie", categorie);
        request.setAttribute("prix", prix);
        request.setAttribute("dateDebut", date);
        request.setAttribute("dateFin", dateFin);
        request.setAttribute("rue", rue);
        request.setAttribute("codePostal", codePostal);
        request.setAttribute("ville", ville);


    }
}
