package org.example.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class DetalleProductoPage {
    public static final Target INP_CANTIDAD = Target.the("campo de cantidad del producto")
            .located(By.cssSelector("input.qty-input"));
    public static final Target BTN_AGREGAR_CARRITO = Target.the("boton agregar al carrito")
            .located(By.cssSelector("input.add-to-cart-button"));
    public static final Target MSG_NOTIFICACION = Target.the("mensaje de notificacion")
            .located(By.cssSelector("#bar-notification .content"));
}