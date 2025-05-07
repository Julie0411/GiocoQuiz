package org.julie.progetto.modulo320.QuizGame;

import java.util.List;

public interface Valutabile {

    int valuta();
    void visualizzaDomanda();
    List<String> getRisposteDate();
    void setRisposteDate(List<String> risposteDate);
    String getDomanda();

}
