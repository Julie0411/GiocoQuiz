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
        //TODO adjust this loop it doenst work properly
        for (String rC : risposteCorrette) {
            for (String r : getRisposteDate()) {
                if (r.equals(rC)) {
                    punteggio++;
                } else {
                    if (punteggio > 0) {
                        punteggio--;
                    }
                }
            }
        }
        return punteggio;
    }

}
