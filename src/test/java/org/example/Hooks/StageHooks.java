package org.example.Hooks;

import io.cucumber.java.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.example.Utils.Parameters;
import org.example.Utils.ScreenShot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class StageHooks {
    private static final Logger LOGGER = LoggerFactory.getLogger(StageHooks.class);
    private int numeroPaso;

    @Before
    public void setTheStage(Scenario scenario) {
        LOGGER.info("=====================================================");
        LOGGER.info("Iniciando escenario: {}", scenario.getName());
        OnStage.setTheStage(new OnlineCast());
        numeroPaso = 1;
        String nombreCarpeta = scenario.getName();
        Parameters.RutaEvidenciaActual = Parameters.RutaEvidencia + ScreenShot.getCurrentDateTime() + "_" + nombreCarpeta;
        ScreenShot.createFolder(Parameters.RutaEvidenciaActual);
    }
    @AfterStep
    public void tomarCapturaPorPaso() {
        try {
            ScreenShot.captureScreenshot(getDriver(), Parameters.RutaEvidenciaActual, "Paso_" + numeroPaso);
            numeroPaso++;
        } catch (Exception e) {
            LOGGER.warn("No se pudo tomar la captura del paso {}: {}", numeroPaso, e.getMessage());
        }
    }
    @After
    public void tearDown(Scenario scenario) {
        LOGGER.info("Finalizando escenario: {} | Estado: {}", scenario.getName(), scenario.getStatus());
        OnStage.drawTheCurtain();
    }
}