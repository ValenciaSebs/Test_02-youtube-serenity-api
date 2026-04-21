package com.knotacademy.qc.serenity.youtube.stepdefinitions;

import com.knotacademy.qc.serenity.youtube.steps.YouTubeVideoActions;
import com.knotacademy.qc.serenity.youtube.steps.YouTubeAssertions;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

public class VideoSteps {
    @Steps
    private YouTubeVideoActions videoActions;

    @Steps
    private YouTubeAssertions assertions;

    // ==================== CUANDO ====================

    @Cuando("consulto el video con ID {string}")
    public void consultarVideo(String videoId) {
        videoActions.consultarVideo(videoId);
    }

    @Cuando("consulto el video con ID {string} con partes {string}")
    public void consultarVideoConPartes(String videoId, String parts) {
        videoActions.consultarVideoConPartes(videoId, parts);
    }

    @Cuando("consulto los videos {string}")
    public void consultarMultiplesVideos(String videoIds) {
        videoActions.consultarMultiplesVideos(videoIds);
    }

    // ==================== ENTONCES ====================
    // NOTA: "el código de respuesta es {int}" está en CommonSteps

    @Entonces("el video tiene título, descripción y canal")
    public void verificarDatosBasicosVideo() {
        assertions.verificarDatosBasicosVideo();
    }

    @Entonces("las estadísticas incluyen vistas y likes")
    public void verificarEstadisticas() {
        assertions.verificarEstadisticasVideo();
    }

    @Entonces("el snippet contiene título, channelTitle y publishedAt")
    public void verificarCamposSnippetVideo() {
        assertions.verificarCamposSnippetVideo();
    }

    @Entonces("las estadísticas contienen viewCount y likeCount")
    public void verificarCamposEstadisticas() {
        assertions.verificarCamposEstadisticasVideo();
    }

    @Entonces("el contentDetails contiene duración y definición")
    public void verificarCamposContentDetails() {
        assertions.verificarCamposContentDetails();
    }

    @Entonces("la respuesta no contiene videos")
    public void verificarSinVideos() {
        assertions.verificarSinResultados();
    }

    @Entonces("el viewCount es un string numérico mayor a {int}")
    public void verificarViewCountValido(int minValue) {
        assertions.verificarViewCountValido(minValue);
    }

    @Entonces("la duración tiene formato ISO 8601")
    public void verificarFormatoIso8601() {
        assertions.verificarFormatoIso8601();
    }

    @Entonces("la respuesta contiene solo datos de snippet sin estadísticas")
    public void verificarSoloSnippet() {
        assertions.verificarSoloSnippet();
    }

    @Entonces("la respuesta contiene exactamente {int} videos")
    public void verificarExactamenteVideos(int expectedCount) {
        assertions.verificarExactamenteNResultados(expectedCount);
    }
}
