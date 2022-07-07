package fr.afpa.enchere.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ArticlesVendus {
   private int noArticle;
   private String nomArticle;
   private String description;
   private Date dateDebutEnchere;
   private Date dateFinEnchere;
   private int miseAPrix;
   private int prixVente;
   private String etatVente;


}
