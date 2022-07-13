package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Articles_Vendus;
import fr.afpa.enchere.bo.UtilisateursArticles_Vendus;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleSQL {
    private static final String SELECT_ALL = "SELECT no_article, nom_article, description, " +
            " date_debut_encheres, date_fin_encheres, prix_initial, " +
            " prix_vente, no_utilisateur, no_categorie " +
            " FROM articles_vendus";

    private static final String SELECT_ALL1 = "SELECT no_article, nom_article, prix_vente, date_fin_encheres, pseudo," +
            " utilisateurs.no_utilisateur" +
            " FROM articles_vendus " +
            " INNER JOIN utilisateurs " +
            "ON articles_vendus.no_utilisateur = utilisateurs.no_utilisateur";

    private static final String SELECT_BY_NOM_ARTICLE_ET_NO_CATEGORIE = "SELECT no_article, nom_article, prix_vente, date_fin_encheres, " +
            "pseudo, utilisateurs.no_utilisateur" +
            " FROM articles_vendus " +
            " INNER JOIN utilisateurs " +
            " ON articles_vendus.no_utilisateur = utilisateurs.no_utilisateur " +
            " INNER JOIN categories " +
            " ON articles_vendus.no_categorie = categories.no_categorie" +
            " WHERE articles_vendus.nom_article LIKE ? AND categories.no_categorie LIKE ?";

    private static final String DELETE_ARTICLE = "DELETE FROM articles_vendus WHERE no_utilisateur = ?";

    private static final String INSERT_INTO_ARTICLES = "INSERT INTO articles_vendus(nom_article, description," +
            " date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_DERNIER = "SELECT no_article FROM articles_vendus" +
            " ORDER BY no_article DESC LIMIT 1";

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
                listeArticles.add(new UtilisateursArticles_Vendus(rs.getInt("no_article"), rs.getString("nom_article"), rs.getInt("prix_vente"), rs.getDate("date_fin_encheres"), rs.getString("pseudo"), rs.getString("no_utilisateur")));
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
                listeArticles.add(new UtilisateursArticles_Vendus(rs.getInt("no_article"), rs.getString("nom_article"), rs.getInt("prix_vente"), rs.getDate("date_fin_encheres"), rs.getString("pseudo"), rs.getString("no_utilisateur")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeArticles;
    }

    public void deleteArticle(int no_utilisateur) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(DELETE_ARTICLE);
            pstmt.setInt(1, no_utilisateur);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoArticles(String nom_article, String description, Date date_debut_encheres, Date date_fin_encheres,
                                   int prix_initial, int no_utilisateur, int no_categorie) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            try {
                connection.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                pstmt = connection.prepareStatement(INSERT_INTO_ARTICLES);
                pstmt.setString(1, nom_article);
                pstmt.setString(2, description);
                pstmt.setDate(3, date_debut_encheres);
                pstmt.setDate(4, date_fin_encheres);
                pstmt.setInt(5, prix_initial);
                pstmt.setInt(6, no_utilisateur);
                pstmt.setInt(7, no_categorie);
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

    public int selectDernier() {
        int id_article = 0;
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_DERNIER);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id_article = ((rs.getInt("no_article")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id_article;
    }

}
