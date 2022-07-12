package fr.afpa.enchere.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Articles_vendusCategoriesRetraitsUtilisateurs {
    private int no_article;
    private String nom_article;
    private String description;
    private String libelle;
    private int prix_vente;
    private int prix_initial;
    private Date date_fin_encheres;
    private String rue;
    private String codePostal;
    private String ville;
    private String pseudo;
    private int no_utilisateur;
    private int no_categorie;

    public Articles_vendusCategoriesRetraitsUtilisateurs(String nom_article, String description, String libelle, int prix_vente, int prix_initial, Date date_fin_encheres, String rue, String codePostal, String ville, String pseudo) {
        this.nom_article = nom_article;
        this.description = description;
        this.libelle = libelle;
        this.prix_vente = prix_vente;
        this.prix_initial = prix_initial;
        this.date_fin_encheres = date_fin_encheres;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pseudo = pseudo;
    }
}
