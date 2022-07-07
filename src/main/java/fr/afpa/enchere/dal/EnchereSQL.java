package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Encheres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnchereSQL {
    private static final String SELECT_ALL = "SELECT no_encheres, no_utilisateur, no_article, date_enchere, montant_enchere FROM encheres";

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

}
