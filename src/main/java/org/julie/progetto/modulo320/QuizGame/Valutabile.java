package org.julie.progetto.modulo320.QuizGame;

/**
 * Rappresenta un'entità che può essere valutata restituendo un punteggio numerico.
 * Le classi che implementano questa interfaccia devono fornire una logica per
 * calcolare e restituire una valutazione come valore float.
 */
public interface Valutabile {

    /**
     * Calcola e restituisce una valutazione dell'oggetto.
     * @return un valore float che rappresenta la valutazione dell'oggetto
     */
    float valuta();

}
