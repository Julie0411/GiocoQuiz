package org.julie.progetto.modulo320;

import org.julie.progetto.modulo320.QuizGame.DomdandaPiuRisposteCorrette;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDomdandaPiuRisposteCorrette {

    @Test
    public void test_domanda_con_piu_risposte_corrette_se_passo_una_domanda_nulla_deve_lanciare_errore() {
        List<String> risposte = new ArrayList<>(List.of("Svizzera", "Italia", "Francia", "Germania"));
        List<String> risposteCorrette = new ArrayList<>(List.of("Svizzera", "Germania"));
        assertThrows(IllegalArgumentException.class, ()-> {new DomdandaPiuRisposteCorrette(null, risposte, risposteCorrette);});
    }

    @Test
    public void test_domanda_con_piu_risposte_corrette_se_passo_una_lista_di_risposte_nulla_deve_lanciare_errore() {
        List<String> risposteCorrette = new ArrayList<>(List.of("Svizzera", "Germania"));
        assertThrows(IllegalArgumentException.class, ()-> {new DomdandaPiuRisposteCorrette("In quali di queste nazioni di parla tedesco?", null, risposteCorrette);});
    }

    @Test
    public void test_domanda_con_piu_risposte_corrette_se_passo_la_risposta_corretta_come_nulla_deve_lanciare_errore() {
        List<String> risposte = new ArrayList<>(List.of("Svizzera", "Italia", "Francia", "Germania"));
        assertThrows(IllegalArgumentException.class, ()-> {new DomdandaPiuRisposteCorrette("In quali di queste nazioni di parla tedesco?", risposte, null);});
    }

    @Test
    public void test_domanda_con_piu_risposte_corrette_se_le_mie_risposte_sono_giuste_il_punteggio_deve_essere_1() {
        List<String> risposte = new ArrayList<>(List.of("Svizzera", "Italia", "Francia", "Germania"));
        List<String> risposteCorrette = new ArrayList<>(List.of("Svizzera", "Germania"));
        DomdandaPiuRisposteCorrette domanda = new DomdandaPiuRisposteCorrette("In quali di queste nazioni di parla tedesco?", risposte, risposteCorrette);
        List<String> risposteDate = new ArrayList<>(List.of("Svizzera", "Germania"));
        domanda.setRisposteDate(risposteDate);
        assertEquals(1, domanda.valuta());
    }

    @Test
    public void test_domanda_con_piu_risposte_corrette_se_le_mie_risposte_sono_sbagliate_il_punteggio_deve_essere_0() {
        List<String> risposte = new ArrayList<>(List.of("Svizzera", "Italia", "Francia", "Germania"));
        List<String> risposteCorrette = new ArrayList<>(List.of("Svizzera", "Germania"));
        DomdandaPiuRisposteCorrette domanda = new DomdandaPiuRisposteCorrette("In quali di queste nazioni di parla tedesco?", risposte, risposteCorrette);
        List<String> risposteDate = new ArrayList<>(List.of("Italia", "Francia"));
        domanda.setRisposteDate(risposteDate);
        assertEquals(0, domanda.valuta());
    }

}
