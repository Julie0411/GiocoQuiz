package org.julie.progetto.modulo320.QuizGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cli {
    public static void main(String[] args) {

        List<Domanda> domande = new ArrayList<>();

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
                    Domanda d;
                    System.out.println("Scrivi la domanda: ");
                    String domanda = s.nextLine();
                    System.out.println("Scrivi due o più risposte (separa con la virgola): ");
                    String risposteUnite = s.nextLine();
                    List<String> risposte = List.of(risposteUnite.split(", "));
                    System.out.println("Quante sono le risposte corrette: ");
                    int nuemroRisposteCorrette = s.nextInt();
                    s.nextLine();
                    if (nuemroRisposteCorrette == 1) {
                        System.out.println("Scrivi la risposta corretta: ");
                        String rispostaCorretta = s.nextLine();
                        d = new DomandaSingolaRispostaCorretta(domanda, risposte, rispostaCorretta);
                        domande.add(d);
                    } else if (nuemroRisposteCorrette > 1) {
                        System.out.println("Scrivi le risposte corrette (separa con la virgola): ");
                        List<String> risposteCorrette = List.of(s.nextLine().split(", "));
                        d = new DomdandaPiuRisposteCorrette(domanda, risposte, risposteCorrette);
                        domande.add(d);
                    } else {
                        System.out.println("Questo numero non è valido riprova");
                    }
                    System.out.println("Vuoi aggiungere un altra domanda?");
                    String r = s.nextLine();
                    if (r.equalsIgnoreCase("no")) {
                        break;
                    }
                }
            } else if (risposta == 2) {
                //TODO implement logic to drop a question here
            } else if (risposta == 3) {
                for (Domanda d : domande) {
                    System.out.println("Ecco tutte le domande con le relative risposte: ");
                    d.visualizzaDomanda();
                }
            } else if (risposta == 4) {
                int punteggioTotale = 0;
                for (Domanda d : domande) {
                    System.out.println("Ecco la domanda: ");
                    d.visualizzaDomanda();
                    System.out.println("Risposta (se più di una separare con la virgola): ");
                    List<String> risposteDate = List.of(s.nextLine().split(", "));
                    d.setRisposteDate(risposteDate);
                }
            } else if (risposta == 5) {
                break;
            } else {
                System.out.println("Numero non valido, riprova");
            }
        }
    }
}
