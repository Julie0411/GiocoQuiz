package org.julie.progetto.modulo320.QuizGame;

import java.util.List;

public class DomdandaPiuRisposteCorrette extends Domanda {

    private List<String> risposteCorrette;

    public DomdandaPiuRisposteCorrette(String domanda, List<String> risposte, List<String> risposteCorrette) {
        super(domanda, risposte);
        if (risposteCorrette == null) throw new IllegalArgumentException("Ci devono essere delle risposte corrette!");
        this.risposteCorrette = risposteCorrette;
    }

    @Override
    public int valuta() {
        int punteggio = 0;
        for (String r : getRisposteDate()) {
            for (String rC : risposteCorrette) {
                if (r.equals(rC)) {
                    punteggio++;
                } else {
                    punteggio--;
                }
            }
        }
        return punteggio;
    }

}
