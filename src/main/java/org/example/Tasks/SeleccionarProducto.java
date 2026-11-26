package org.example.Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.ResultadoBusquedaPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SeleccionarProducto {
    public static Performable fromResults(String nombreProducto) {
        return Task.where("{0} selecciona el producto " + nombreProducto,
                WaitUntil.the(ResultadoBusquedaPage.LNK_PRODUCTO.of(nombreProducto), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ResultadoBusquedaPage.LNK_PRODUCTO.of(nombreProducto))
        );
    }
}
