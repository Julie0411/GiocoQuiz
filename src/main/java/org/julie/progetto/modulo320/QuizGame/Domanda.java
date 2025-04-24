package org.julie.progetto.modulo320.QuizGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Domanda implements Valutabile {

    private String domanda;
    private List<String> risposte;
    private List<String> risposteCorrette;
    private List<String> risposteDate;
    private int punteggioTotale;

    public Domanda(String domanda, List<String> risposte, List<String> risposteCorrette, List<String> risposteDate) {
        if (domanda == null) throw new IllegalArgumentException("Devi passare una domanda!");
        if (risposte == null) throw new IllegalArgumentException("Devi passare delle risposte!");
        this.domanda = domanda;
        this.risposte = risposte;
        this.risposteCorrette = risposteCorrette;
        this.risposteDate = risposteDate;
        this.punteggioTotale = risposteCorrette.size();
    }

    public void visualizzaDomanda() {
        System.out.println(domanda);
        for (int i = 0; i < risposte.size()-1; i++) {
            System.out.println(i+1 + ": " + risposte.get(i));
        }
    }

    @Override
    public int valuta() {
        int punteggio = 0;
        for (String r : risposteDate) {
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
