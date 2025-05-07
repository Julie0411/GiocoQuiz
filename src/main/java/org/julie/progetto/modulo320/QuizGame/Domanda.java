package org.julie.progetto.modulo320.QuizGame;

import java.util.List;

public abstract class Domanda implements Valutabile {

    private String domanda;
    private List<String> risposte;
    private List<String> risposteDate;

    public Domanda(String domanda, List<String> risposte) {
        if (domanda == null) throw new IllegalArgumentException("Devi passare una domanda!");
        if (risposte == null) throw new IllegalArgumentException("Devi passare delle risposte!");
        this.domanda = domanda;
        this.risposte = risposte;
    }

    @Override
    public void visualizzaDomanda() {
        System.out.println(domanda);
        for (int i = 0; i < risposte.size()-1; i++) {
            System.out.println(i+1 + ": " + risposte.get(i));
        }
    }

    @Override
    public List<String> getRisposteDate() {
        return risposteDate;
    }

    @Override
    public void setRisposteDate(List<String> risposteDate) {
        this.risposteDate = risposteDate;
    }

    @Override
    public String getDomanda() {
        return this.domanda;
    }

}
