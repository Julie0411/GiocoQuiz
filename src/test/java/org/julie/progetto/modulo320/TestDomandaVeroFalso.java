package org.julie.progetto.modulo320;

import org.julie.progetto.modulo320.quizGame.DomandaVeroFalso;
import org.testng.annotations.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDomandaVeroFalso {

    @Test
    public void test_domanda_vero_falso_se_passo_una_domanda_nulla_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaVeroFalso(null, "Vero", "Biologia");});
    }

    @Test
    public void test_domanda_vero_falso_se_passo_la_risposta_corretta_come_nulla_deve_lanciare_errore() {
        assertThrows(NullPointerException.class, ()-> {new DomandaVeroFalso("Il cielo è azzurro?", null, "Chimica");});
    }

    @Test
    public void test_domanda_vero_falso_se_passo_un_argomento_nullo_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaVeroFalso("Il cielo è azzurro?", "vero", null);});
    }

    @Test
    public void test_domanda_vero_falso_se_la_mia_risposta_e_giusta_il_punteggio_deve_essere_1() {
        DomandaVeroFalso domanda = new DomandaVeroFalso("Il cielo è azzurro?", "Vero", "Fisica");
        Set<String> risposteDate = Set.of("Vero");
        domanda.setRisposteDate(risposteDate);
        assertEquals(1, domanda.valuta());
    }

    @Test
    public void test_domanda_vero_falso_se_la_mia_risposta_e_sbagliata_il_punteggio_deve_essere_0() {
        DomandaVeroFalso domanda = new DomandaVeroFalso("Il cielo è azzurro?", "Vero", "Matematica");
        Set<String> risposteDate = Set.of("Falso");
        domanda.setRisposteDate(risposteDate);
        assertEquals(0, domanda.valuta());
    }

}
