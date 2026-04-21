package com.knotacademy.qc.serenity.youtube.stepdefinitions;

import com.knotacademy.qc.serenity.youtube.steps.YouTubeAssertions;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

/**
 * Step definitions compartidos entre todos los features.
 * Evita duplicar @Entonces en múltiples clases (DuplicateStepDefinitionException).
 */
public class CommonSteps {

    @Steps
    private YouTubeAssertions assertions;

    @Dado("que tengo acceso a la API de YouTube")
    public void setupYouTubeApi() {
        // API key is loaded from serenity.conf
    }

    @Entonces("el código de respuesta es {int}")
    public void verificarStatusCode(int expectedCode) {
        assertions.verificarStatusCode(expectedCode);
    }
}
