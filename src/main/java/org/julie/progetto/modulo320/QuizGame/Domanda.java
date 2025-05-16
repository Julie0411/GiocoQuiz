package org.julie.progetto.modulo320.quizGame;

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
// TODO: mancano Javadoc sulla classe e sul costruttore.
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
        rispostePossibili = toLowerCase(rispostePossibili);
        risposteCorrette = toLowerCase(risposteCorrette);
        if (!rispostePossibili.containsAll(risposteCorrette)) throw new IllegalArgumentException("La risposta corretta deve essere tra quelle possibili!");
        if (categoria == null || categoria.trim().isEmpty()) throw new IllegalArgumentException("Categoria non può essere vuota!");
        //TODO: E' lecito avere una domanda con zero risposte possibili?
        //TODO: E' lecito avere una domanda che sia una stringa vuota?
        this.domanda = domanda;
        this.rispostePossibili = rispostePossibili;
        this.risposteCorrette = risposteCorrette;
        this.categoria = categoria;
        this.categorie.add(categoria);
    }

    /**
     * Visualizza la domanda e tutte le risposte possibili sulla console.
     */
    /* TODO: sarebbe meglio che questo metodo restituisse una stringa e delegare al chiamante la responsabilità.
    * Immagina ad esempio di voler inviare ad una stampante l'output invece di volerlo stampare a video...
    * di scrivere su console (oppure altrove). Alternativamente, puoi mettere l'outputstream come parametro d'ingresso
    * al metodo.
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
    // TODO: perchè questo metodo è pubblico? Perché sono andata di default senza pensare
    private static float arrotonda(float numero, int numeriDopoLaVirgola) {
        // TODO: cosa succede se ti mando un "numeriDopoLaVirgola" negativo? Ora viene Gestito
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
                    // TODO: non capisco questo if. O meglio, ne capisco l'intenzione (non andare in negativo)... ma
                    // non minimizza i WTF/min. Non saprei come sostituire questo controllo
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
    // TODO: questa classe rappresenta una risposta "chiusa", ovvero una domanda in cui l'utente puo' scegliere
    // una o piú risposte tra un set di risposte disponibili.
    // in questo momento la tua classe permette di scegliere risposte esterne al set di risposte possibili. La cosa
    // genera un elevato numero di WTF/min. Sei sicura di volere questo comportamento? Se si, devi documentarlo e documentare
    // perchè secondo te ha senso.
    // Lo uso nei test e nella cli per assegnare il valore, ho aggiungo un controllo per vedere se sono risposte valide
    public void setRisposteDate(Set<String> risposteDate) {
        if (!(toLowerCase(rispostePossibili).containsAll(toLowerCase(risposteDate)))) throw new IllegalArgumentException("Assicurati di dare solo risposte che sono valide!");
        this.risposteDate = risposteDate;

    }

    /**
     * Restituisce il testo della domanda.
     * @return la domanda come stringa
     */
    public String getDomanda() {
        return this.domanda;
    }

    /**
     * Restituisce la categoria della domanda.
     * @return la categoria come stringa
     */
    public String getCategoria() {
        return categoria;
    }
}
