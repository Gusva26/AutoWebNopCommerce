package org.example.Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.DetalleProductoPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Notificacion {
    public static Question<String> text() {
        return actor -> {
            actor.attemptsTo(
                    WaitUntil.the(DetalleProductoPage.MSG_NOTIFICACION, isVisible()).forNoMoreThan(10).seconds()
            );
            return Text.of(DetalleProductoPage.MSG_NOTIFICACION).answeredBy(actor).trim();
        };
    }
}