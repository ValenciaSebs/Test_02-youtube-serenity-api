package com.knotacademy.qc.serenity.youtube.steps;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;

public class YouTubeVideoActions extends YouTubeApiActions {

    @Step("Consultar video con ID: {0}")
    public void consultarVideo(String videoId) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet,statistics")
            .queryParam("id", videoId)
            .when()
            .get("/videos"));
    }

    @Step("Consultar video con ID: {0} con partes: {1}")
    public void consultarVideoConPartes(String videoId, String parts) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", parts)
            .queryParam("id", videoId)
            .when()
            .get("/videos"));
    }

    @Step("Consultar múltiples videos: {0}")
    public void consultarMultiplesVideos(String videoIds) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet,statistics")
            .queryParam("id", videoIds)
            .when()
            .get("/videos"));
    }
}
