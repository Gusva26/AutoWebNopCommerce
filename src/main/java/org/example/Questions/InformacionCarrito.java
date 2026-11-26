package org.example.Questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.CarritoPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InformacionCarrito {
    public static Question<String> nombreProducto() {
        return actor -> {
            actor.attemptsTo(
                    WaitUntil.the(CarritoPage.LBL_NOMBRE_PRODUCTO, isVisible()).forNoMoreThan(10).seconds()
            );
            return Text.of(CarritoPage.LBL_NOMBRE_PRODUCTO).answeredBy(actor).trim();
        };
    }
    public static Question<String> cantidadProducto() {
        return actor -> {
            actor.attemptsTo(
                    WaitUntil.the(CarritoPage.INP_CANTIDAD_CARRITO, isVisible()).forNoMoreThan(10).seconds()
            );
            return Value.of(CarritoPage.INP_CANTIDAD_CARRITO).answeredBy(actor).trim();
        };
    }
    public static Question<String> mensajeVacio() {
        return actor -> {
            actor.attemptsTo(
                    WaitUntil.the(CarritoPage.MSG_CARRITO_VACIO, isVisible()).forNoMoreThan(10).seconds()
            );
            return Text.of(CarritoPage.MSG_CARRITO_VACIO).answeredBy(actor).trim();
        };
    }
}