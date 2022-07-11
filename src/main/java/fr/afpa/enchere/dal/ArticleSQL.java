package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Articles_Vendus;
import fr.afpa.enchere.bo.Encheres;
import fr.afpa.enchere.bo.UtilisateursArticles_Vendus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleSQL {
    private static final String SELECT_ALL = "SELECT no_article, nom_article, description, " +
            " date_debut_encheres, date_fin_encheres, prix_initial, " +
            " prix_vente, no_utilisateur, no_categorie " +
            " FROM articles_vendus";

    private static final String SELECT_ALL1 = "SELECT nom_article, prix_vente, date_fin_encheres, pseudo" +
            " FROM articles_vendus " +
            " INNER JOIN utilisateurs " +
            "ON articles_vendus.no_utilisateur = utilisateurs.no_utilisateur";

    private static final String SELECT_BY_NOM_ARTICLE_ET_NO_CATEGORIE = "SELECT nom_article, prix_vente, date_fin_encheres, pseudo" +
            " FROM articles_vendus " +
            " INNER JOIN utilisateurs " +
            " ON articles_vendus.no_utilisateur = utilisateurs.no_utilisateur " +
            " INNER JOIN categories " +
            " ON articles_vendus.no_categorie = categories.no_categorie" +
            " WHERE articles_vendus.nom_article LIKE ? AND categories.no_categorie LIKE ?";

    public List<Articles_Vendus> selectAll() {
        List<Articles_Vendus> listeArticles = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeArticles.add(new Articles_Vendus(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"), rs.getDate("date_debut_encheres"), rs.getDate("date_fin_encheres"), rs.getInt("prix_initial"), rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeArticles;
    }

    public List<UtilisateursArticles_Vendus> selectAll1() {
        List<UtilisateursArticles_Vendus> listeArticles = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL1);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeArticles.add(new UtilisateursArticles_Vendus(rs.getString("nom_article"), rs.getInt("prix_vente"), rs.getDate("date_fin_encheres"), rs.getString("pseudo")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeArticles;
    }

    public List<UtilisateursArticles_Vendus> selectByNomArticleEtNoCategorie(String name, int no_categorie) {
        List<UtilisateursArticles_Vendus> listeArticles = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_NOM_ARTICLE_ET_NO_CATEGORIE);
            pstmt.setString(1, "%" + name + "%");
            pstmt.setInt(2, no_categorie);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeArticles.add(new UtilisateursArticles_Vendus(rs.getString("nom_article"), rs.getInt("prix_vente"), rs.getDate("date_fin_encheres"), rs.getString("pseudo")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeArticles;
    }
}
