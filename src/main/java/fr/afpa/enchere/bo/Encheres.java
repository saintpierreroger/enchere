package fr.afpa.enchere.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Encheres {
    private Date dateEnchere;
    private int montant_enchere;

}
