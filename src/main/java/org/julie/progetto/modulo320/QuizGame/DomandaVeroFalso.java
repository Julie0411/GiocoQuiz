package org.julie.progetto.modulo320.QuizGame;

import java.util.List;

public class DomandaVeroFalso implements Valutabile {

    private String domanda;
    private enum risposte {Vero, Falso}
    private String rispostaCorretta;
    private List<String> risposteDate;

    public DomandaVeroFalso(String domanda, String rispostaCorretta) {
        if (domanda == null) throw new IllegalArgumentException("Devi passare una domanda!");
        if (rispostaCorretta == null) throw new IllegalArgumentException("Devi passare una risposta corretta!");
        this.domanda = domanda;
        this.rispostaCorretta = rispostaCorretta;
    }

    public void visualizzaDomanda() {
        System.out.println(domanda);
        System.out.println(risposte.Vero);
        System.out.println(risposte.Falso);
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

    @Override
    public int valuta() {
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
