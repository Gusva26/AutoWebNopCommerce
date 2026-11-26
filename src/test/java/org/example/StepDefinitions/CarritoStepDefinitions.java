package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.example.Questions.InformacionCarrito;
import org.example.Questions.MensajeResultadoBusqueda;
import org.example.Questions.Notificacion;
import org.example.Tasks.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class CarritoStepDefinitions {
    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {
        actor.attemptsTo(NavigateHome.openPage());
    }

    @When("busca el producto {string}")
    public void buscaElProducto(String producto) {
        theActorInTheSpotlight().attemptsTo(BuscarProducto.byName(producto));
    }

    @And("selecciona el producto {string} de los resultados")
    public void seleccionaElProductoDeLosResultados(String producto) {
        theActorInTheSpotlight().attemptsTo(SeleccionarProducto.fromResults(producto));
    }

    @And("ingresa la cantidad {string} y lo agrega al carrito")
    public void ingresaLaCantidadYLoAgregaAlCarrito(String cantidad) {
        theActorInTheSpotlight().attemptsTo(AñadirProductoCarrito.withQuantity(cantidad));
    }

    @Then("deberia ver el mensaje de confirmacion {string}")
    public void deberiaVerElMensajeDeConfirmacion(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                seeThat("el mensaje de confirmacion",
                        Notificacion.text(),
                        containsString(mensajeEsperado))
        );
    }

    @When("ingresa al carrito de compras")
    public void ingresaAlCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(AbrirCarrito.now());
    }

    @Then("el producto {string} deberia aparecer en el carrito con cantidad {string}")
    public void elProductoDeberiaAparecerEnElCarritoConCantidad(String productoEsperado, String cantidadEsperada) {
        theActorInTheSpotlight().should(
                seeThat("el nombre del producto en el carrito",
                        InformacionCarrito.nombreProducto(),
                        equalTo(productoEsperado)),
                seeThat("la cantidad del producto en el carrito",
                        InformacionCarrito.cantidadProducto(),
                        equalTo(cantidadEsperada))
        );
    }

    @And("elimina el producto del carrito")
    public void eliminaElProductoDelCarrito() {
        theActorInTheSpotlight().attemptsTo(RemoverProductoCarrito.firstItem());
    }

    @Then("deberia ver el carrito vacio con el mensaje {string}")
    public void deberiaVerElCarritoVacioConElMensaje(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                seeThat("el mensaje de carrito vacio",
                        InformacionCarrito.mensajeVacio(),
                        equalTo(mensajeEsperado))
        );
    }

    @Then("deberia ver el mensaje de busqueda sin resultados {string}")
    public void deberiaVerElMensajeDeBusquedaSinResultados(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                seeThat("el mensaje de busqueda sin resultados",
                        MensajeResultadoBusqueda.sinResultados(),
                        equalTo(mensajeEsperado))
        );
    }
}