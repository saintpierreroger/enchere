package fr.afpa.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RequeteSQL {

    public void insertCreaCompteSQL(String pseudo, String nom, String prenom, String email, String telephone, String rue, int codePostal, String ville, String motDePasse, String confirmPassWord) {
        //Cette methode sert a inserer un utilisateur dans la BDD
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe) value(?,?,?,?,?,?,?,?,?);");
            pstmt.setString(1, pseudo);
            pstmt.setString(2, nom);
            pstmt.setString(3, prenom);
            pstmt.setString(4, email);
            pstmt.setString(5, telephone);
            pstmt.setString(6, rue);
            pstmt.setInt(7, codePostal);
            pstmt.setString(8, ville);
            pstmt.setString(9, motDePasse);
            pstmt.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }


}
