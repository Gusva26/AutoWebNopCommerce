package org.example.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CarritoPage {
    public static final Target LBL_NOMBRE_PRODUCTO = Target.the("nombre del producto en el carrito")
            .located(By.cssSelector("td.product a.product-name"));
    public static final Target INP_CANTIDAD_CARRITO = Target.the("cantidad del producto en el carrito")
            .located(By.cssSelector("table.cart input.qty-input"));
    public static final Target CHK_ELIMINAR = Target.the("casilla para eliminar producto del carrito")
            .located(By.cssSelector("input[name='removefromcart']"));
    public static final Target BTN_ACTUALIZAR_CARRITO = Target.the("boton actualizar carrito")
            .located(By.cssSelector("input[name='updatecart']"));
    public static final Target MSG_CARRITO_VACIO = Target.the("mensaje de carrito vacio")
            .located(By.cssSelector("div.order-summary-content"));
}