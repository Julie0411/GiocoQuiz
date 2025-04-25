package org.julie.progetto.modulo320;

import org.julie.progetto.modulo320.QuizGame.DomandaSingolaRispostaCorretta;
import org.julie.progetto.modulo320.QuizGame.DomdandaPiuRisposteCorrette;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDomdandaPiuRisposteCorrette {

    @Test
    public void test_Domanda_con_piu_risposte_corrette_se_passo_una_domanda_nulla_deve_lanciare_errore() {
        List<String> risposte = new ArrayList<>();
        risposte.add("Svizzera");
        risposte.add("Italia");
        risposte.add("Francia");
        risposte.add("Germania");
        List<String> risposteCorrette = new ArrayList<>();
        risposteCorrette.add("Svizzera");
        risposteCorrette.add("Germania");
        assertThrows(IllegalArgumentException.class, ()-> {new DomdandaPiuRisposteCorrette(null, risposte, risposteCorrette);});
    }

    @Test
    public void test_Domanda_con_piu_risposte_corrette_se_passo_una_lista_di_risposte_nulla_deve_lanciare_errore() {
        List<String> risposteCorrette = new ArrayList<>();
        risposteCorrette.add("Svizzera");
        risposteCorrette.add("Germania");
        assertThrows(IllegalArgumentException.class, ()-> {new DomdandaPiuRisposteCorrette("In quali di queste nazioni di parla tedesco?", null, risposteCorrette);});
    }

    @Test
    public void test_Domanda_con_una_risposta_corretta_se_passo_la_risposta_corretta_come_nulla_deve_lanciare_errore() {
        List<String> risposte = new ArrayList<>();
        risposte.add("Svizzera");
        risposte.add("Italia");
        risposte.add("Francia");
        risposte.add("Germania");
        assertThrows(IllegalArgumentException.class, ()-> {new DomdandaPiuRisposteCorrette("In quali di queste nazioni di parla tedesco?", risposte, null);});
    }

}
