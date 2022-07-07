package fr.afpa.enchere.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Encheres {
    private int no_encheres;
    private int no_utilisateur;
    private int no_article;
    private Date dateEnchere;
    private int montant_enchere;

}
