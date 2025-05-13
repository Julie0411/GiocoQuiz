package org.julie.progetto.modulo320.quizGame;

import java.util.Set;

/**
 * Rappresenta una domanda a risposta chiusa di tipo Vero/Falso.
 * Estende la classe {@link Domanda} e permette la valutazione basata su una sola risposta corretta.
 */
public class DomandaVeroFalso extends Domanda {

    /**
     * Costruisce una nuova istanza della classe {@code DomandaVeroFalso}.
     * @param domanda La domanda sotto forma di stringa. Non può essere null o vuota.
     * @param rispostaCorretta La risposta corretta sotto forma di stringa, che deve essere "Vero" o "Falso".
     * @throws IllegalArgumentException Se la risposta corretta non è né "vero" né "falso".
     * @see Domanda
     */
    // TODO: mi verrebbe piú naturale avere come parametro "rispostaCorretta" un boolean.
    public DomandaVeroFalso(String domanda, String rispostaCorretta, String categoria) {
        // TODO: le stringhe "Vero" e "Falso" hardcoded non sono belle e osn pure replicate (non rispetti il DRY principle
        // se non sai cosa c'è, cerca online). Meglio dichiarare una ENUM o due costanti (public static final...)
        super(domanda, Set.of("vero", "falso"), ignoreCase(Set.of((rispostaCorretta))), categoria);
        if (!(rispostaCorretta.equalsIgnoreCase("vero") || rispostaCorretta.equalsIgnoreCase("falso"))) throw new IllegalArgumentException("La risposta corretta deve essere o vero o falso!");
    }

    /**
     * Valuta la risposta fornita dall'utente.
     * Se tra le risposte date è presente quella corretta, restituisce 1 punto, altrimenti 0.
     *
     * @return il punteggio ottenuto: 1 se corretto, 0 altrimenti
     */

}
