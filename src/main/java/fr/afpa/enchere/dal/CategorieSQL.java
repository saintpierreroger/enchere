package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Articles_Vendus;
import fr.afpa.enchere.bo.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategorieSQL {
    static final String SELECT_NO_CATEGORIE = "SELECT no_categorie, libelle FROM categories";

    public List<Categories> selectNoCategories() {
        List<Categories> listeCategories = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_NO_CATEGORIE);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeCategories.add(new Categories(rs.getInt("no_categorie"), rs.getString("libelle")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeCategories;
    }
}
