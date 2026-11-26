package org.example.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ResultadoBusquedaPage {
    public static final Target LNK_PRODUCTO = Target.the("producto {0} en los resultados")
            .locatedBy("//h2[@class='product-title']/a[normalize-space()='{0}']");
    public static final Target MSG_SIN_RESULTADOS = Target.the("mensaje de busqueda sin resultados")
            .located(By.cssSelector("div.search-results"));
}