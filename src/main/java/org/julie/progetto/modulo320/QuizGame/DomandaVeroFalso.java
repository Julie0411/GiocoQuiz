package org.julie.progetto.modulo320.QuizGame;

import java.util.ArrayList;
import java.util.List;

public class DomandaVeroFalso extends Domanda {

    private String rispostaCorretta;

    public DomandaVeroFalso(String domanda, String rispostaCorretta) {
        super(domanda, new ArrayList<>((List.of("Vero", "Falso"))));
        this.rispostaCorretta = rispostaCorretta;
    }

    @Override
    public int valuta() {
        return 0;
    }

}
