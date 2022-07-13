package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Articles_vendusCategoriesUtilisateurs;
import fr.afpa.enchere.bo.Retraits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetraitSQL {
    private static final String SELECT_ALL = "SELECT rue, code_postal, ville FROM retraits WHERE no_article = ?";

    private static final String INSERT_INTO_RETRAITS = "INSERT INTO retraits(no_article, rue, code_postal, ville)" +
            " VALUES (?, ?, ?, ?)";

    public Retraits select_all(int no_article) {
        Retraits retraits = new Retraits();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL);
            pstmt.setInt(1, no_article);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                retraits = new Retraits(
                        rs.getString("rue"),
                        rs.getString("code_postal"),
                        rs.getString("ville"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retraits;
    }

    public void insertIntoRetraits(int no_article, String rue, String code_postal, String ville) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                pstmt = connection.prepareStatement(INSERT_INTO_RETRAITS);
                pstmt.setInt(1, no_article);
                pstmt.setString(2, rue);
                pstmt.setString(3, code_postal);
                pstmt.setString(4, ville);
                pstmt.executeUpdate();
                pstmt.close();
                connection.commit();
            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
