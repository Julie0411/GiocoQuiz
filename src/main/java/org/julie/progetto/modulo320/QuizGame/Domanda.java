package org.julie.progetto.modulo320.QuizGame;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

/**
 * Questa classe rappresenta una domanda all'interno di un quiz.
 * La classe è astratta in quanto deve essere estesa in domande singole o multiple.
 * Implementa l'interfaccia {@link Valutabile} per fornire un metodo di valutazione delle risposte.
 * <p>Una domanda contiene:
 * <ul>
 *     <li>una domanda</li>
 *     <li>delle risposte possibili</li>
 *     <li>le risposte corrette</li>
 *     <li>Le risposte corrette</li>
 * </ul>
 * La valutazione delle risposte è fatta confrontando quelle date con quelle corrette, dando un punteggio basato
 * sulla correttezza e sulla penalizzazione delle risposte errate.
 * @see Valutabile
 */
public abstract class Domanda implements Valutabile {

    private String domanda;
    private Set<String> rispostePossibili;
    private Set<String> risposteCorrette;
    private Set<String> risposteDate;
    private String categoria;
    private Set<String> categorie = new HashSet<>();

    /**
     * Costruisce una nuova istanza della classe {@code Domanda}.
     * @param domanda La domanda sotto forma di stringa. Non può essere null o vuota.
     * @param rispostePossibili L'insieme delle risposte possibili, non può essere null.
     * @param risposteCorrette L'insieme delle risposte corrette, non può essere null o vuoto.
     * @throws IllegalArgumentException Se uno dei parametri è null o se la domanda è vuota.
     */
    public Domanda(String domanda, Set<String> rispostePossibili, Set<String> risposteCorrette, String categoria) {
        if (domanda == null || domanda.isEmpty()) throw new IllegalArgumentException("La domanda non può essere vuota!");
        if (rispostePossibili == null || rispostePossibili.isEmpty()) throw new IllegalArgumentException("Devi passare delle risposte!");
        if (risposteCorrette == null || risposteCorrette.isEmpty()) throw new IllegalArgumentException("Devi passare una risposta corretta!");
        rispostePossibili = separaRisposte(toLowerCase(rispostePossibili));
        risposteCorrette = separaRisposte(toLowerCase(risposteCorrette));
        if (!rispostePossibili.containsAll(risposteCorrette)) throw new IllegalArgumentException("La risposta corretta deve essere tra quelle possibili!");
        if (categoria == null || categoria.trim().isEmpty()) throw new IllegalArgumentException("Categoria non può essere vuota!");
        this.domanda = domanda;
        this.rispostePossibili = rispostePossibili;
        this.risposteCorrette = risposteCorrette;
        this.categoria = categoria;
        this.categorie.add(categoria);
    }

    /**
     * @return una string contenente la domanda e le risposte
     */
    public String visualizzaDomanda() {
        int i = 0;
        StringBuilder risposte = new StringBuilder();
        for (String s : rispostePossibili) {
            risposte.append(s.replace("[", "").replace("]", ""));
            if (i < rispostePossibili.size() - 1) {
                risposte.append(",");
            }
            i++;
        }
        return this.domanda + "\nRisposte: " + risposte;
    }

    /**
     * Restituisce il numero passato come parametro arrotondato al numero di decimali specificato.
     * @param numero il numero da arrotondare
     * @param numeriDopoLaVirgola il numero di cifre decimali desiderato
     * @return il numero arrotondato con il numero di decimali specificato
     */
    private static float arrotonda(float numero, int numeriDopoLaVirgola) {
        if (numeriDopoLaVirgola < 0) throw new IllegalArgumentException("Devi passare un numero positivo! ");
        BigDecimal bigDecimal = new BigDecimal(numero);
        bigDecimal = bigDecimal.setScale(numeriDopoLaVirgola, RoundingMode.HALF_DOWN);
        return (float) bigDecimal.doubleValue();
    }

    /**
     * Riceve un set di stringhe e le mette tutte a lowercase
     * @param setIniziale - il set con le stringe da convertire
     * @return il set con tutte le stringe messe a lowercase
     */
    static Set<String> toLowerCase(Set<String> setIniziale) {
        if (setIniziale == null || setIniziale.isEmpty()) throw new IllegalArgumentException(("Devi passare un set popolato!"));
        Set<String> setFinale = new HashSet<>();
        for (String s : setIniziale) {
            setFinale.add(s.toLowerCase());
        }
        return setFinale;
    }

    /**
     * Riceve un set di stringhe che è composto da una stringa e separa le varie risposte
     * @param setIniziale - il set con le stringe da separare
     * @return il set con tutte le stringe separate
     */
    static Set<String> separaRisposte(Set<String> setIniziale) {
        Set<String> setFinale = new HashSet<>();
        for (String s : setIniziale) {
            Set<String> setIntermedio = Set.of(s.split(","));
            for (String str : setIntermedio) {
                setFinale.add(str.trim());
            }
        }
        return setFinale;
    }

    /**
     * Valuta le risposte date e calcola il punteggio ottenuto.
     * Ogni risposta corretta aggiunge 1 punto. Le risposte errate sottraggono un
     * punteggio proporzionale al numero totale di risposte possibili meno uno.
     * Il punteggio finale viene arrotondato a due decimali.
     * @return il punteggio calcolato tra 0 e il numero di risposte corrette
     */
    @Override
    public float valuta() {
        float punteggio = 0;
        float punteggioErrore = (float) 1.0 /(rispostePossibili.size()-1);
        for (String rD : toLowerCase(this.risposteDate)) {
            for (String rC : toLowerCase(this.risposteCorrette)) {
                if (rD.equals(rC)) {
                    punteggio++;
                } else {
                    punteggio -= punteggioErrore;
                }
            }
        }
        return arrotonda(Math.max(0, punteggio), 2);
    }

    /**
     * Imposta le risposte date dall'utente.
     * @param risposteDate un set contenente le risposte fornite dall'utente
     */
    public void setRisposteDate(Set<String> risposteDate) {
        if (!(toLowerCase(rispostePossibili).containsAll(toLowerCase(risposteDate)))) throw new IllegalArgumentException("Assicurati di dare solo risposte che sono valide!");
        this.risposteDate = risposteDate;

    }

    /**
     * Restituisce la categoria della domanda.
     * @return la categoria come stringa
     */
    public String getCategoria() {
        return categoria;
    }
}
