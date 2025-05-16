package org.julie.progetto.modulo320.quizGame;

import java.util.Set;

/**
 * Rappresenta una domanda a risposta multipla con una o più risposte corrette.
 * Estende la classe astratta {@link Domanda} e implementa il metodo {@code valuta}
 * per calcolare il punteggio sulla base delle risposte date.
 */
public class DomandaRispostaMultipla extends Domanda {

    /**
     * Costruisce una nuova istanza della classe {@code DomandaRispostaMultipla}.
     * @param domanda La domanda sotto forma di stringa. Non può essere null o vuota.
     * @param rispostePossibili L'insieme delle risposte possibili, non può essere null.
     * @param risposteCorrette L'insieme delle risposte corrette, non può essere null o vuoto.
     * @throws IllegalArgumentException Se le risposte corrette sono null o vuote, o se contengono risposte non presenti nell'insieme delle risposte possibili.
     * @see Domanda
     */
    public DomandaRispostaMultipla(String domanda, Set<String> rispostePossibili, Set<String> risposteCorrette, String categoria) {
        super(domanda, rispostePossibili, risposteCorrette, categoria);
        // TODO: sposta questo controllo nella classe Domanda.
        // TODO: qui hai creato un nuovo set, e hai copiato dentro tutte le stringhe. Nella classe Domanda invece hai assegnato
        // la reference passata esternamente. Perchè questa differenza?
    }

}
