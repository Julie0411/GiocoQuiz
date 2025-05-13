package org.julie.progetto.modulo320.quizGame;

import java.util.HashSet;

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
        super(domanda, ignoreCase(rispostePossibili), ignoreCase(risposteCorrette), categoria);
        // TODO: sposta questo controllo nella classe Domanda.
        // TODO: qui hai creato un nuovo set, e hai copiato dentro tutte le stringhe. Nella classe Domanda invece hai assegnato
        // la reference passata esternamente. Perchè questa differenza?
    }

    /**
     * Valuta le risposte date e calcola il punteggio ottenuto.
     * Ogni risposta corretta aggiunge 1 punto. Le risposte errate sottraggono un
     * punteggio proporzionale al numero totale di risposte possibili meno uno.
     * Il punteggio finale viene arrotondato a due decimali.
     *
     * @return il punteggio calcolato tra 0 e il numero di risposte corrette
     */
//    @Override
    // TODO: puoi portare nella classe Domanda questa implementazione.
//    public float valuta() {
//        float punteggio = 0;
//        float punteggioErrore = (float) 1.0 /(getNumeroRisposte()-1);
//        for (String rD : getRisposteDate()) {
//            for (String rC : risposteCorrette) {
//                if (rD.equals(rC)) {
//                    punteggio++;
//                } else {
//                    // TODO: non capisco questo if. O meglio, ne capisco l'intenzione (non andare in negativo)... ma
//                    // non minimizza i WTF/min.
//                    if ((punteggio - punteggioErrore) >= punteggioErrore) {
//                        punteggio -= punteggioErrore;
//                    }
//                }
//            }
//        }
//
//        return arrotonda(punteggio, 2);
//    }

}
