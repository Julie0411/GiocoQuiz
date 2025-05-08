package org.julie.progetto.modulo320.quizGame;

import java.util.List;
import java.util.Set;

public class DomandaVeroFalso extends Domanda {

    private String rispostaCorretta;

    public DomandaVeroFalso(String domanda, String rispostaCorretta) {
        super(domanda, Set.of("Vero", "Falso"));
        if (rispostaCorretta == null) throw new IllegalArgumentException("Devi passare una risposta corretta!");
        if (!(rispostaCorretta.equalsIgnoreCase("Vero") || rispostaCorretta.equalsIgnoreCase("Falso"))) throw new IllegalArgumentException("La risposta corretta deve essere o vero o falso!");
        this.rispostaCorretta = rispostaCorretta;
    }

    @Override
    public float valuta() {
        int punti = 0;
        for (String r : getRisposteDate()) {
            if (r.equals(rispostaCorretta)) {
                punti += 1;
                break;
            }
        }
        return punti;
    }

}
