package org.julie.progetto.modulo320.QuizGame;

import java.util.Set;

/**
 * Rappresenta una domanda a risposta chiusa di tipo Vero/Falso.
 * Estende la classe {@link Domanda} e permette la valutazione basata su una sola risposta corretta.
 */
public class DomandaVeroFalso extends Domanda {

    public static final String vero = "vero";
    public static final String falso = "falso";

    /**
     * Costruisce una nuova istanza della classe {@code DomandaVeroFalso}.
     * @param domanda La domanda sotto forma di stringa. Non può essere null o vuota.
     * @param rispostaCorretta La risposta corretta sotto forma di stringa, che deve essere "Vero" o "Falso".
     * @see Domanda
     */
    public DomandaVeroFalso(String domanda, String rispostaCorretta, String categoria) {
        super(domanda, Set.of(vero, falso), Set.of((rispostaCorretta)), categoria);
    }

}
