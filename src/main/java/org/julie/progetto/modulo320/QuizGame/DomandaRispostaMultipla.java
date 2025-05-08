package org.julie.progetto.modulo320.quizGame;

import java.util.HashSet;

import java.util.Set;

public class DomandaRispostaMultipla extends Domanda {

    private Set<String> risposteCorrette;

    public DomandaRispostaMultipla(String domanda, Set<String> rispostePossibili, Set<String> risposteCorrette) {
        super(domanda, rispostePossibili);
        if (risposteCorrette == null || risposteCorrette.isEmpty()) throw new IllegalArgumentException("Devi passare una lista con almeno una risposta corretta!");
        if (!rispostePossibili.containsAll(risposteCorrette)) throw new IllegalArgumentException("La risposta deve essere presente nelle risposte possibili!");
        this.risposteCorrette = new HashSet<>(risposteCorrette);
    }

    @Override
    public float valuta() {
        float punteggio = 0;
        float punteggioErrore = (float) 1.0 /(getNumeroRisposte()-1);
        for (String rD : getRisposteDate()) {
            for (String rC : risposteCorrette) {
                if (rD.equals(rC)) {
                    punteggio++;
                } else {
                    if ((punteggio - punteggioErrore) >= punteggioErrore) {
                        punteggio -= punteggioErrore;
                    }
                }
            }
        }
        return arrotonda(punteggio, 2);
    }

}
