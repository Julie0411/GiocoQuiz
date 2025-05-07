package org.julie.progetto.modulo320.QuizGame;

public class DomandaVeroFalso implements Valutabile {

    private String domanda;
    private enum risposte {Vero, Falso}
    private String rispostaCorretta;

    public DomandaVeroFalso(String domanda, String rispostaCorretta) {
        this.domanda = domanda;
        this.rispostaCorretta = rispostaCorretta;
    }

    public void visualizzaDomanda() {
        System.out.println(domanda);
        System.out.println(risposte.Vero);
        System.out.println(risposte.Falso);
    }

    @Override
    public int valuta() {
        if (this.rispostaCorretta.equals(risposte.Vero.toString())) {
            return 1;
        } else if (this.rispostaCorretta.equals(risposte.Falso.toString())) {
            return 1;
        } else {
            return 0;
        }
    }
}
