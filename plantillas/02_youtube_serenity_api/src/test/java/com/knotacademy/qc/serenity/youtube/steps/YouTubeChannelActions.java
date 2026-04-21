package com.knotacademy.qc.serenity.youtube.steps;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;

public class YouTubeChannelActions extends YouTubeApiActions {

    @Step("Consultar canal con ID: {0}")
    public void consultarCanal(String channelId) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet,statistics")
            .queryParam("id", channelId)
            .when()
            .get("/channels"));
    }

    @Step("Consultar canal con ID: {0} con partes: {1}")
    public void consultarCanalConPartes(String channelId, String parts) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", parts)
            .queryParam("id", channelId)
            .when()
            .get("/channels"));
    }

    @Step("Consultar múltiples canales: {0}")
    public void consultarMultiplesCanales(String channelIds) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet,statistics")
            .queryParam("id", channelIds)
            .when()
            .get("/channels"));
    }
}
