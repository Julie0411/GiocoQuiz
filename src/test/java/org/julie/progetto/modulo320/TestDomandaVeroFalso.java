package org.julie.progetto.modulo320;

import org.julie.progetto.modulo320.QuizGame.DomandaVeroFalso;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDomandaVeroFalso {

    @Test
    public void test_domanda_vero_falso_se_passo_una_domanda_nulla_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaVeroFalso(null, "Vero");});
    }

    @Test
    public void test_domanda_vero_falso_se_passo_la_risposta_corretta_come_nulla_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaVeroFalso("Il cielo è azzurro?", null);});
    }

    @Test
    public void test_domanda_vero_falso_se_la_mia_risposta_e_giusta_il_punteggio_deve_essere_1() {
        DomandaVeroFalso domanda = new DomandaVeroFalso("Il cielo è azzurro?", "Vero");
        List<String> risposteDate = List.of("Vero");
        domanda.setRisposteDate(risposteDate);
        assertEquals(1, domanda.valuta());
    }

    @Test
    public void test_domanda_vero_falso_se_la_mia_risposta_e_sbagliata_il_punteggio_deve_essere_0() {
        DomandaVeroFalso domanda = new DomandaVeroFalso("Il cielo è azzurro?", "Vero");
        List<String> risposteDate = List.of("Falso");
        domanda.setRisposteDate(risposteDate);
        assertEquals(0, domanda.valuta());
    }

}
