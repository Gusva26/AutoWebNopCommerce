package org.example.Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirCarrito {
    public static Performable now() {
        return Task.where("{0} ingresa al carrito de compras",
                WaitUntil.the(HomePage.LNK_CARRITO, isVisible()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(HomePage.LNK_CARRITO)
        );
    }
}
