package org.julie.progetto.modulo320.QuizGame;

import java.util.List;

public class DomandaSingolaRispostaCorretta extends Domanda {

    private String rispostaCorretta;

    public DomandaSingolaRispostaCorretta(String domanda, List<String> risposte, String rispostaCorretta) {
        super(domanda, risposte);
        if (rispostaCorretta == null) throw new IllegalArgumentException("Ci deve essere una risposta corretta!");
        this.rispostaCorretta = rispostaCorretta;
    }

    @Override
    public int valuta() {
        int punteggio = 0;
        for (String r : getRisposteDate()) {
            if (r.equals(this.rispostaCorretta)) {
                punteggio++;
            } else {
                punteggio--;
            }
        }
        return punteggio;
    }

}
