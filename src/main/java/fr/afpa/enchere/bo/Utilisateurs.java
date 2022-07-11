package fr.afpa.enchere.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Utilisateurs {

    private int noUtilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String rue;
    private String codePostal;
    private String ville;
    private String motDePasse;
    private int credit;
    private boolean administrateur;

    //constructeur pour la methode "modifier le compte".


    public Utilisateurs(String pseudo, String nom, String prenom, String mail, String telephone, String rue, String codePostal, String ville) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Utilisateurs(String pseudo, String motDePasse) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
    }

    public Utilisateurs(int noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }


}
