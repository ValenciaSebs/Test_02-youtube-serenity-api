package com.knotacademy.qc.serenity.youtube.stepdefinitions;

import com.knotacademy.qc.serenity.youtube.steps.YouTubeSearchActions;
import com.knotacademy.qc.serenity.youtube.steps.YouTubeAssertions;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

public class SearchSteps {
    @Steps
    private YouTubeSearchActions searchActions;

    @Steps
    private YouTubeAssertions assertions;

    // ==================== CUANDO (acciones) ====================

    @Cuando("busco videos con el término {string}")
    public void buscarVideos(String query) {
        searchActions.buscarVideos(query);
    }

    @Cuando("busco videos con el término {string} y máximo {int} resultados")
    public void buscarVideosConMaxResults(String query, int maxResults) {
        searchActions.buscarVideosConMaxResults(query, maxResults);
    }

    @Cuando("busco videos con el término {string} ordenados por {string}")
    public void buscarVideosConOrden(String query, String orderBy) {
        searchActions.buscarVideosConOrden(query, orderBy);
    }

    @Cuando("busco playlists con el término {string}")
    public void buscarPlaylists(String query) {
        searchActions.buscarPlaylists(query);
    }

    // ==================== ENTONCES (assertions) ====================
    // NOTA: "el código de respuesta es {int}" está en CommonSteps

    @Entonces("la respuesta contiene al menos {int} resultado")
    public void verificarAlMenosUnResultado(int minResults) {
        assertions.verificarAlMenosNResultados(minResults);
    }

    @Entonces("la respuesta contiene exactamente {int} resultados")
    public void verificarExactamenteResultados(int expectedCount) {
        assertions.verificarExactamenteNResultados(expectedCount);
    }

    @Entonces("cada resultado tiene un título válido")
    public void verificarTitulosValidos() {
        assertions.verificarTitulosValidos();
    }

    @Entonces("cada resultado tiene un ID de video")
    public void verificarIdsVideos() {
        assertions.verificarIdsVideos();
    }

    @Entonces("cada resultado contiene los campos obligatorios de snippet")
    public void verificarCamposSnippet() {
        assertions.verificarCamposSnippet();
    }

    @Entonces("el pageInfo indica el total de resultados")
    public void verificarPageInfo() {
        assertions.verificarPageInfo();
    }

    @Entonces("la respuesta contiene resultados ordenados")
    public void verificarResultadosOrdenados() {
        assertions.verificarResultadosOrdenados();
    }

    @Entonces("la respuesta incluye un token de siguiente página")
    public void verificarTokenPaginacion() {
        assertions.verificarTokenPaginacion();
    }

    @Entonces("cada resultado es de tipo {string}")
    public void verificarTipoResultado(String type) {
        assertions.verificarTipoResultado(type);
    }
}
