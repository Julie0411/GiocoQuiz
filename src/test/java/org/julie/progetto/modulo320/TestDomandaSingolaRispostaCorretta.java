package org.julie.progetto.modulo320;

import org.julie.progetto.modulo320.QuizGame.DomandaSingolaRispostaCorretta;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDomandaSingolaRispostaCorretta {

    @Test
    public void test_Domanda_con_una_risposta_corretta_se_passo_una_domanda_nulla_deve_lanciare_errore() {
        List<String> risposte = new ArrayList<>();
        risposte.add("Boh");
        risposte.add("Ciao");
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaSingolaRispostaCorretta(null, risposte, "Ciao");});
    }

    @Test
    public void test_Domanda_con_una_risposta_corretta_se_passo_una_lista_di_risposte_nulla_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaSingolaRispostaCorretta("Cosa si dice per salutare?", null, "Ciao");});
    }

    @Test
    public void test_Domanda_con_una_risposta_corretta_se_passo_la_risposta_corretta_come_nulla_deve_lanciare_errore() {
        List<String> risposte = new ArrayList<>();
        risposte.add("Boh");
        risposte.add("Ciao");
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaSingolaRispostaCorretta("Cosa si dice per salutare?", risposte, null);});
    }

}
