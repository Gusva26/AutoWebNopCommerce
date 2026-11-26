package org.example.Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.ResultadoBusquedaPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MensajeResultadoBusqueda {
    public static Question<String> sinResultados() {
        return actor -> {
            actor.attemptsTo(
                    WaitUntil.the(ResultadoBusquedaPage.MSG_SIN_RESULTADOS, isVisible()).forNoMoreThan(10).seconds()
            );
            return Text.of(ResultadoBusquedaPage.MSG_SIN_RESULTADOS).answeredBy(actor).trim();
        };
    }
}