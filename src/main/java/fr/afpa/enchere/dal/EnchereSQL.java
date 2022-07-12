package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Encheres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnchereSQL {
    private static final String SELECT_ALL = "SELECT no_encheres, no_utilisateur, " +
            "no_article, date_enchere, montant_enchere " +
            "FROM encheres";
    private static final String INSERT_ENCHERE = "INSERT INTO encheres(no_utilisateur, no_article, date_enchere, montant_enchere)" +
            " VALUES (?, ?, ?, ?) ";


    public List<Encheres> selectAll() {
        List<Encheres> listeEncheres = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeEncheres.add(new Encheres(rs.getInt("no_encheres"), rs.getInt("no_utilisateur"), rs.getInt("no_article"), rs.getDate("date_enchere"), rs.getInt("montant_enchere")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeEncheres;
    }

    public void insertEnchere(int no_utilisateur, int no_article, Date date_enchere, int montant_enchere) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                pstmt = connection.prepareStatement(INSERT_ENCHERE);
                pstmt.setInt(1, no_utilisateur);
                pstmt.setInt(2, no_article);
                pstmt.setDate(3, (java.sql.Date) date_enchere);
                pstmt.setInt(4, montant_enchere);
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
