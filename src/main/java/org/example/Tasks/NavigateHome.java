package org.example.Tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.example.Pages.HomePage;

public class NavigateHome {
    public static Performable openPage() {
        return Task.where("{0} abre la pagina de inicio de DemoWebShop",
                Open.browserOn().the(HomePage.class)
        );
    }
}