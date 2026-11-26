package org.example.Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarProducto {
    public static Performable byName(String nombreProducto) {
        return Task.where("{0} busca el producto " + nombreProducto,
                WaitUntil.the(HomePage.INP_BUSCAR, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombreProducto).into(HomePage.INP_BUSCAR),
                Click.on(HomePage.BTN_BUSCAR)
        );
    }
}
