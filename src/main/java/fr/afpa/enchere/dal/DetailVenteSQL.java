package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Articles_vendusCategoriesUtilisateurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetailVenteSQL {

    private static final String SELECT_ARTICLE = " SELECT nom_article, description, categories.libelle, prix_vente," +
            " prix_initial, date_fin_encheres, utilisateurs.pseudo, articles_vendus.no_utilisateur," +
            " articles_vendus.no_categorie" +
            " FROM articles_vendus" +
            " INNER JOIN categories" +
            " ON articles_vendus.no_categorie = categories.no_categorie" +
            " INNER JOIN utilisateurs" +
            " ON articles_vendus.no_utilisateur = utilisateurs.no_utilisateur" +
            " WHERE articles_vendus.no_article = ?";

    public Articles_vendusCategoriesUtilisateurs select_article(int id) {
        Articles_vendusCategoriesUtilisateurs detailVente = new Articles_vendusCategoriesUtilisateurs();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ARTICLE);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                detailVente = new Articles_vendusCategoriesUtilisateurs(
                        rs.getString("nom_article"),
                        rs.getString("description"),
                        rs.getString("libelle"),
                        rs.getInt("prix_vente"),
                        rs.getInt("prix_initial"),
                        rs.getDate("date_fin_encheres"),
                        rs.getString("pseudo"));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailVente;
    }
}
