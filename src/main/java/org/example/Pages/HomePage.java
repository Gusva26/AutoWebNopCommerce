package org.example.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://demowebshop.tricentis.com/")
public class HomePage extends PageObject {
    public static final Target INP_BUSCAR = Target.the("campo de busqueda de productos")
            .located(By.id("small-searchterms"));
    public static final Target BTN_BUSCAR = Target.the("boton de buscar")
            .located(By.cssSelector("input.search-box-button"));
    public static final Target LNK_CARRITO = Target.the("enlace del carrito de compras")
            .located(By.cssSelector("a.ico-cart"));
}