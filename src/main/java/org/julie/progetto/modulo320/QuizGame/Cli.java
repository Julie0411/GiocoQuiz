package org.julie.progetto.modulo320.quizGame;

import java.util.*;

/**
 * Questa è la cli(command line interface) e serve per far interfacciare l'utente con il programma.
 * */

public class Cli {
    public static void main(String[] args) {

        Set<Domanda> domande = new HashSet<>();
        Set<String> categorie = new HashSet<>();
        Scanner s = new Scanner(System.in);

        for (;;) {
            System.out.println("Scegli l'opzione:");
            System.out.println("1. Aggiungi una domanda");
            System.out.println("2. Rimuovi una domanda");
            System.out.println("3. Visualizza le domande");
            System.out.println("4. Prova il quiz");
            System.out.println("5. Esci");

            int risposta = s.nextInt();
            s.nextLine();
            if (risposta == 1) {
                for (;;) {
                    System.out.println("Che tipo di domanda vuoi fare? (1: Vero o falso - 2: Risposta multipla)");
                    int tipoDomanda = s.nextInt();
                    s.nextLine();
                    if (tipoDomanda == 1) {
                        Domanda d;
                        System.out.println("Scrivi la domanda: ");
                        String domanda = s.nextLine();
                        System.out.println("È vero o è falso?");
                        String rispostaCorretta = s.nextLine();
                        System.out.println("Di che categoria è la domanda?");
                        String categoria = "";
                        categoria = aggiungiOScegliCategoria(categorie, s);
                        d = new DomandaVeroFalso(domanda, rispostaCorretta, categoria);
                        domande.add(d);
                    } else if (tipoDomanda == 2) {
                        Domanda d;
                        System.out.println("Scrivi la domanda: ");
                        String domanda = s.nextLine();
                        System.out.println("Scrivi due o più risposte (separa con la virgola): ");
                        String risposteUnite = s.nextLine();
                        risposteUnite = Arrays.toString(risposteUnite.split(" "));
                        Set<String> rispostePossibili = Set.of(risposteUnite.split(","));
                        System.out.println("Scrivi le risposte corrette (separa con la virgola): ");
                        Set<String> risposteCorrette = Set.of(s.nextLine().split(", "));
                        System.out.println("Di che categoria è la domanda?");
                        String categoria;
                        categoria = aggiungiOScegliCategoria(categorie, s);
                        d = new DomandaRispostaMultipla(domanda, rispostePossibili, risposteCorrette, categoria);
                        domande.add(d);
                    } else {
                        System.out.println("Numero non valido");
                    }
                    System.out.println("Vuoi aggiungere un altra domanda?");
                    String r = s.nextLine();
                    if (r.equalsIgnoreCase("no")) {
                        break;
                    }
                }
            } else if (risposta == 2) {
                System.out.println("Scrivi la domanda da eliminare:");
                String domanda = s.nextLine();
                domande.removeIf(d -> domanda.equals(d.getDomanda()));
            } else if (risposta == 3) {
                System.out.println("Ecco tutte le domande con le relative risposte: ");
                for (Domanda d : domande) {
                    System.out.println(d.visualizzaDomanda());
                }
            } else if (risposta == 4) {
                float punteggioTotale = 0.0f;
                List<String> listaCatTemp = new ArrayList<>();
                int i = 1;
                int cat;
                cat = selezionaCategoria(categorie, s, listaCatTemp, i);
                System.out.println("Ecco le categorie di domande");
                for (Domanda d : domande) {
                    if (d.getCategoria().equals(listaCatTemp.get(cat))) {
                        System.out.println("Ecco la domanda: ");
                        System.out.println(d.visualizzaDomanda());
                        System.out.println("Risposta (se più di una separare con la virgola): ");
                        Set<String> risposteDate = new HashSet<>(Set.of(s.nextLine().split(", ")));
                        for (String r : risposteDate) {
                            risposteDate.remove(r);
                            r = r.replace("[", "").replace("]", "");
                            risposteDate.add(r);
                        }
                        d.setRisposteDate(risposteDate);
                        punteggioTotale += d.valuta();
                    }
                }
                System.out.println("Hai fatto " + punteggioTotale + " punti.");
            } else if (risposta == 5) {
                break;
            } else {
                System.out.println("Numero non valido, riprova");
            }
        }
    }

    private static String aggiungiOScegliCategoria(Set<String> categorie, Scanner s) {
        String categoria;
        if (categorie.isEmpty()) {
            categoria = s.nextLine();
            categorie.add(categoria);
        } else {
            System.out.println("Ecco le categorie che esistono già:");
            for (String c : categorie)  {
                System.out.println(c);
            }
            System.out.println("Scrivi quella che vuoi usare (puoi anche aggiungerne una nuova)");
            categoria = s.nextLine();
            categorie.add(categoria);
        }
        return categoria;
    }

    private static int selezionaCategoria(Set<String> categorie, Scanner s, List<String> listaCatTemp, int i) {
        int cat;
        if (!(categorie.isEmpty())) {
            for (String c : categorie) {
                listaCatTemp.add(c);
                System.out.println(i + ": c");
                i++;
            }
            System.out.println("Inserisci il numero della categoria: ");
            cat = s.nextInt()-1;
            s.nextLine();
            categorie.add(listaCatTemp.get(cat));
            return cat;
        } else {
            System.out.println("Non ci sono domande!");
            return 0;
        }
    }
}
