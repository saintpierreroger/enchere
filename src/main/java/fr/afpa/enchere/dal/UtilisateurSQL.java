package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Utilisateurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurSQL {
    private static final String SELECT_BY_ID = "SELECT rue, code_postal, ville FROM Utilisateurs WHERE no_utilisateur = ?";

    public List<Utilisateurs> selectById(int noUtilisateur) {
        List<Utilisateurs> listeUtilisateur = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, noUtilisateur);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeUtilisateur.add(new Utilisateurs(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeUtilisateur;
    }
}
