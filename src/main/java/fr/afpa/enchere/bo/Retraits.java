package fr.afpa.enchere.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Retraits {
    private String rue;
    private String code_postal;
    private String ville;

    public Retraits() {

    }
}
