package com.knotacademy.qc.serenity.youtube.steps;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;

public class YouTubeSearchActions extends YouTubeApiActions {

    @Step("Buscar videos con término: {0}")
    public void buscarVideos(String query) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet")
            .queryParam("q", query)
            .queryParam("type", "video")
            .queryParam("maxResults", 5)
            .when()
            .get("/search"));
    }

    @Step("Buscar videos con término: {0} y máximo {1} resultados")
    public void buscarVideosConMaxResults(String query, int maxResults) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet")
            .queryParam("q", query)
            .queryParam("type", "video")
            .queryParam("maxResults", maxResults)
            .when()
            .get("/search"));
    }

    @Step("Buscar videos con término: {0} ordenados por {1}")
    public void buscarVideosConOrden(String query, String orderBy) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet")
            .queryParam("q", query)
            .queryParam("type", "video")
            .queryParam("maxResults", 5)
            .queryParam("order", orderBy)
            .when()
            .get("/search"));
    }

    @Step("Buscar playlists con término: {0}")
    public void buscarPlaylists(String query) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet")
            .queryParam("q", query)
            .queryParam("type", "playlist")
            .queryParam("maxResults", 5)
            .when()
            .get("/search"));
    }

    @Step("Obtener siguiente página con token: {0}")
    public void obtenerSiguientePagina(String pageToken) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet")
            .queryParam("pageToken", pageToken)
            .when()
            .get("/search"));
    }
}
