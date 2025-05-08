package org.julie.progetto.modulo320.quizGame;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

public abstract class Domanda implements Valutabile {

    private String domanda;
    private Set<String> rispostePossibili;
    private Set<String> risposteDate;

    public Domanda(String domanda, Set<String> rispostePossibili) {
        if (domanda == null) throw new IllegalArgumentException("Devi passare una domanda!");
        if (rispostePossibili == null) throw new IllegalArgumentException("Devi passare delle risposte!");
        this.domanda = domanda;
        this.rispostePossibili = rispostePossibili;
    }

    public void visualizzaDomanda() {
        System.out.println(domanda);
        for (String s : rispostePossibili) {
            System.out.println(s);
        }
    }

    public static float arrotonda(float numero, int numeriDopoLaVirgola) {
        BigDecimal bigDecimal = new BigDecimal(numero);
        bigDecimal = bigDecimal.setScale(numeriDopoLaVirgola, RoundingMode.HALF_DOWN);
        return (float) bigDecimal.doubleValue();
    }

    public Set<String> getRisposteDate() {
        return risposteDate;
    }

    public void setRisposteDate(Set<String> risposteDate) {
        this.risposteDate = risposteDate;
    }

    public String getDomanda() {
        return this.domanda;
    }

    public int getNumeroRisposte() {
        return rispostePossibili.size();
    }

}
