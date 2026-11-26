package org.example.Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.CarritoPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class RemoverProductoCarrito {
    public static Performable firstItem() {
        return Task.where("{0} elimina el producto del carrito",
                WaitUntil.the(CarritoPage.CHK_ELIMINAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CarritoPage.CHK_ELIMINAR),
                Click.on(CarritoPage.BTN_ACTUALIZAR_CARRITO)
        );
    }
}