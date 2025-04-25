package org.julie.progetto.modulo320;

import org.julie.progetto.modulo320.QuizGame.DomandaSingolaRispostaCorretta;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDomandaSingolaRispostaCorretta {

    @Test
    public void test_domanda_con_una_risposta_corretta_se_passo_una_domanda_nulla_deve_lanciare_errore() {
        List<String> risposte = new ArrayList<>();
        risposte.add("Boh");
        risposte.add("Ciao");
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaSingolaRispostaCorretta(null, risposte, "Ciao");});
    }

    @Test
    public void test_domanda_con_una_risposta_corretta_se_passo_una_lista_di_risposte_nulla_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaSingolaRispostaCorretta("Cosa si dice per salutare?", null, "Ciao");});
    }

    @Test
    public void test_domanda_con_una_risposta_corretta_se_passo_la_risposta_corretta_come_nulla_deve_lanciare_errore() {
        List<String> risposte = new ArrayList<>();
        risposte.add("Boh");
        risposte.add("Ciao");
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaSingolaRispostaCorretta("Cosa si dice per salutare?", risposte, null);});
    }

    @Test
    public void test_domanda_con_una_risposta_corretta_se_la_mia_risposta_e_giusta_il_punteggio_deve_essere_1() {
        List<String> risposte = new ArrayList<>();
        risposte.add("Boh");
        risposte.add("Ciao");
        DomandaSingolaRispostaCorretta domanda = new DomandaSingolaRispostaCorretta("Cosa si dice per salutare?", risposte, "Ciao");
        List<String> risposteDate = List.of("Ciao");
        domanda.setRisposteDate(risposteDate);
        assertEquals(1, domanda.valuta());
    }

    @Test
    public void test_domanda_con_una_risposta_corretta_se_la_mia_risposta_e_sbagliata_il_punteggio_deve_essere_0() {
        List<String> risposte = new ArrayList<>();
        risposte.add("Boh");
        risposte.add("Ciao");
        DomandaSingolaRispostaCorretta domanda = new DomandaSingolaRispostaCorretta("Cosa si dice per salutare?", risposte, "Ciao");
        List<String> risposteDate = List.of("Boh");
        domanda.setRisposteDate(risposteDate);
        assertEquals(0, domanda.valuta());
    }

}
