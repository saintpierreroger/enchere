package fr.afpa.enchere.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UtilisateursArticles_Vendus {
    private String nom_article;
    private int prix_vente;
    private Date date_fin_encheres;
    private String pseudo;

}
