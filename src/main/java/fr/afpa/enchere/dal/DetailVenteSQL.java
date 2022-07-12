package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Articles_vendusCategoriesRetraitsUtilisateurs;
import fr.afpa.enchere.bo.UtilisateursArticles_Vendus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetailVenteSQL {

    private static final String SELECT_ARTICLE = " SELECT nom_article, description, categories.libelle, prix_vente," +
            " prix_initial, date_fin_encheres, retraits.rue, retraits.code_postal, retraits.ville," +
            " utilisateurs.pseudo, articles_vendus.no_utilisateur, articles_vendus.no_categorie" +
            " FROM articles_vendus" +
            " INNER JOIN categories" +
            " ON articles_vendus.no_categorie = categories.no_categorie" +
            " INNER JOIN retraits " +
            " ON articles_vendus.no_article = retraits.no_article" +
            " INNER JOIN utilisateurs" +
            " ON articles_vendus.no_utilisateur = utilisateurs.no_utilisateur";

    public List<Articles_vendusCategoriesRetraitsUtilisateurs> SELECT_ARTICLE(int no_article) {
        List<Articles_vendusCategoriesRetraitsUtilisateurs> detailVente = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ARTICLE);
            pstmt.setInt(1, no_article);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                detailVente.add(new Articles_vendusCategoriesRetraitsUtilisateurs(
                        rs.getString("nom_article"),
                        rs.getString("description"),
                        rs.getString("libelle"),
                        rs.getInt("prix_vente"),
                        rs.getInt("prix_initial"),
                        rs.getDate("date_fin_encheres"),
                        rs.getString("rue"),
                        rs.getString("codePostal"),
                        rs.getString("ville"),
                        rs.getString("pseudo")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailVente;
    }
}
