package org.julie.progetto.modulo320;
import org.julie.progetto.modulo320.QuizGame.DomandaRispostaMultipla;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.Set;

public class TestDomandaRispostaMultipla {

    @Test
    public void test_domanda_risposta_multipla_se_passo_una_domanda_nulla_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaRispostaMultipla(null, Set.of("a", "b", "c", "d"), Set.of("c"), "Italiano");});
    }

    @Test
    public void test_domanda_risposta_multipla_se_passo_null_come_risposte_corrette_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaRispostaMultipla("domanda di prova", null, Set.of("c"), "Storia");});
    }

    @Test
    public void test_domanda_risposta_multipla_se_passo_la_risposta_corretta_come_nulla_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaRispostaMultipla("domanda di prova", Set.of("a", "b", "c", "d"), null, " Geografia");});
    }

    @Test
    public void test_domanda_risposta_multipla_se_passo_la_risposta_corretta_come_lista_vuota_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaRispostaMultipla("domanda di prova", Set.of("a", "b", "c", "d"), Set.of(), "Scienze");});
    }

    @Test
    public void test_domanda_risposta_multipla_se_passo_un_elemento_insistente_come_risposta_corretta_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaRispostaMultipla("domanda di prova", Set.of("a", "b", "c", "d"), Set.of("e"), "Musica");});
    }

    @Test
    public void test_domanda_risposta_multipla_se_passo_una_categoria_nulla_deve_lanciare_errore() {
        assertThrows(IllegalArgumentException.class, ()-> {new DomandaRispostaMultipla("domanda di prova", Set.of("a", "b", "c", "d"), Set.of("a"), null);});
    }

    @Test
    public void test_domanda_risposta_multipla_se_la_mia_risposta_e_sbagliata_il_punteggio_deve_essere_0() {
        DomandaRispostaMultipla domanda = new DomandaRispostaMultipla("domanda di prova", Set.of("a", "b", "c", "d"), Set.of("c"), "Latino");
        Set<String> risposteDate = Set.of("d");
        domanda.setRisposteDate(risposteDate);
        assertEquals(0.0f, domanda.valuta(), 0.0);
    }

    @Test
    public void test_domanda_risposta_multipla_se_ho_messo_una_risposta_giusta_e_una_sbagliata_il_punteggio_deve_essere_0_66() {
        DomandaRispostaMultipla domanda = new DomandaRispostaMultipla("domanda di prova", Set.of("a", "b", "c", "d"), Set.of("c"), "Cucina");
        Set<String> risposteDate = Set.of("c", "d");
        domanda.setRisposteDate(risposteDate);
        assertEquals(0.66f, domanda.valuta(), 2);
    }

    @Test
    public void test_domanda_risposta_multipla_se__ho_messo_una_risposta_giusta_e_due_sbagliate_il_punteggio_deve_essere_0_33() {
        DomandaRispostaMultipla domanda = new DomandaRispostaMultipla("domanda di prova", Set.of("a", "b", "c", "d"), Set.of("c"), "Francese");
        Set<String> risposteDate = Set.of("b", "c", "d");
        domanda.setRisposteDate(risposteDate);
        assertEquals(0.33f, domanda.valuta(), 2);
    }

    @Test
    public void test_domanda_risposta_multipla_se_la_mia_risposta_e_giusta_il_punteggio_deve_essere_1() {
        DomandaRispostaMultipla domanda = new DomandaRispostaMultipla("domanda di prova", Set.of("a", "b", "c", "d"), Set.of("c"), "Tedesco");
        Set<String> risposteDate = Set.of("c");
        domanda.setRisposteDate(risposteDate);
        assertEquals(1.0f, domanda.valuta(), 0.0);
    }

}
