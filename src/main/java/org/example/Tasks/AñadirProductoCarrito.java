package org.example.Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.DetalleProductoPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AñadirProductoCarrito {
    public static Performable withQuantity(String cantidad) {
        return Task.where("{0} ingresa la cantidad " + cantidad + " y agrega el producto al carrito",
                WaitUntil.the(DetalleProductoPage.INP_CANTIDAD, isVisible()).forNoMoreThan(10).seconds(),
                Clear.field(DetalleProductoPage.INP_CANTIDAD),
                Enter.theValue(cantidad).into(DetalleProductoPage.INP_CANTIDAD),
                WaitUntil.the(DetalleProductoPage.BTN_AGREGAR_CARRITO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(DetalleProductoPage.BTN_AGREGAR_CARRITO)
        );
    }
}