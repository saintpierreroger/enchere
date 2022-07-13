package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Articles_vendusCategoriesUtilisateurs;
import fr.afpa.enchere.bo.Retraits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetraitSQL {
    private static final String SELECT_ALL = "SELECT rue, code_postal, ville FROM retraits WHERE no_article = ?";

    public Retraits select_all(int id) {
        Retraits retraits = new Retraits();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                retraits = new Retraits(
                        rs.getString("rue"),
                        rs.getString("code_postale"),
                        rs.getString("ville"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retraits;
    }
}
