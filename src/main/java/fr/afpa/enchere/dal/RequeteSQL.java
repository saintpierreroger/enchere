package fr.afpa.enchere.dal;

import fr.afpa.enchere.bo.Utilisateurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequeteSQL {


    public void insertCreaCompteSQL(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, String confirmPassWord) {
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
            pstmt.setString(7, codePostal);
            pstmt.setString(8, ville);
            pstmt.setString(9, motDePasse);
            pstmt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateMDPlost(String email, String pseudo, String updatePassWord) {
        //REQUETE POUR RECUPERER L'ID DE L'UTILISATEUR.
        int idUser = 0;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement selectId = connection.prepareStatement(
                    "SELECT no_utilisateur , pseudo, email FROM utilisateurs WHERE email = ? and pseudo = ?");
            selectId.setString(1, email);
            selectId.setString(2, pseudo);
            ResultSet rs = selectId.executeQuery();
            while (rs.next()) {
                idUser = rs.getInt("no_utilisateur");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(idUser);
        //REQUETE POUR MODIDIER LE MOT DE PASSE PERDU.
        try {
            Connection cnx = ConnectionProvider.getConnection();
            PreparedStatement pstmt = cnx.prepareStatement(
                    "UPDATE utilisateurs SET mot_de_passe = ? WHERE no_utilisateur= ?");
            pstmt.setString(1, updatePassWord);
            pstmt.setInt(2, idUser);
            pstmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // REQUETE POUR LA CONNEXION A SON PROFIL
    public boolean connexionSQL(String pseudo, String password) {
        int idUser = 0;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT no_utilisateur FROM utilisateurs WHERE pseudo = ? and mot_de_passe = ?");
            pstmt.setString(1, pseudo);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idUser = rs.getInt("no_utilisateur");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (idUser != 0) {
            System.out.println("connecter");
            return true;

        } else {
            System.out.println("pas connecter");
            return false;
        }
    }

    //METHODE FAISANT APPEL A LA REQUETE SQL UPDATE POUR MODIFIER LE PROFIL UTILISATEUR.
    public void modifierProfil(Utilisateurs user) {
        int idUser = 0;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT no_utilisateur FROM utilisateurs WHERE pseudo = ? and mot_de_passe = ?");
            pstmt.setString(1, user.getPseudo());
            pstmt.setString(2, user.getMotDePasse());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idUser = rs.getInt("no_utilisateur");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE utilisateurs SET pseudo = ? , prenom = ? ,nom = ? ,email = ?, telephone = ?, rue = ?, ville = ?, code_postal = ? ,mot_de_passe = ? WHERE no_utilisateur = ?");
            pstmt.setString(1, user.getPseudo());
            pstmt.setString(2, user.getPrenom());
            pstmt.setString(3, user.getNom());
            pstmt.setString(4, user.getMail());
            pstmt.setString(5, user.getTelephone());
            pstmt.setString(6, user.getRue());
            pstmt.setString(7, user.getVille());
            pstmt.setString(8, user.getCodePostal());
            pstmt.setString(9, user.getMotDePasse());
            pstmt.setInt(10, idUser);
            pstmt.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void supprimerCompte(Utilisateurs user) {
        int idUser = 0;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT no_utilisateur FROM utilisateurs WHERE pseudo = ? and mot_de_passe = ?");
            pstmt.setString(1, user.getPseudo());
            pstmt.setString(2, user.getMotDePasse());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idUser = rs.getInt("no_utilisateur");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "DELETE FROM utilisateurs WHERE no_utilisateur = ?");
            pstmt.setInt(1, idUser);
            pstmt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int idUtilisateur(Utilisateurs user) {
        int idUser = 0;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT no_utilisateur FROM utilisateurs WHERE pseudo = ? and mot_de_passe = ?");
            pstmt.setString(1, user.getPseudo());
            pstmt.setString(2, user.getMotDePasse());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idUser = rs.getInt("no_utilisateur");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return idUser;
    }


    public Utilisateurs profilUtilisateur(int idUser) {
        Utilisateurs utilisateur = null;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT pseudo,nom ,prenom,email,telephone,rue,code_postal,ville FROM utilisateurs WHERE no_utilisateur = ?");
            pstmt.setInt(1, idUser);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String pseudo = rs.getString("pseudo");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String telephone = rs.getString("telephone");
                String rue = rs.getString("rue");
                String codePostal = rs.getString("code_postal");
                String ville = rs.getString("ville");
                utilisateur = new Utilisateurs(pseudo, nom, prenom, email, telephone, rue, codePostal, ville);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return utilisateur;
    }

    public int id(String pseudo) {
        int idUser = 0;

        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM utilisateurs WHERE pseudo = ?");
            pstmt.setString(1, pseudo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idUser = rs.getInt("no_utilisateur");

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return idUser;
    }
}
