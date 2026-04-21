package com.knotacademy.qc.serenity.youtube.steps;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;

public class YouTubeCategoryActions extends YouTubeApiActions {

    @Step("Consultar categorías para región: {0}")
    public void consultarCategoriasParaRegion(String regionCode) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet")
            .queryParam("regionCode", regionCode)
            .when()
            .get("/videoCategories"));
    }

    @Step("Obtener categorías con idioma: {0} para región: {1}")
    public void consultarCategoriasConIdioma(String hl, String regionCode) {
        saveResponse(SerenityRest.given()
            .baseUri(getBaseUrl())
            .queryParam("key", getApiKey())
            .queryParam("part", "snippet")
            .queryParam("regionCode", regionCode)
            .queryParam("hl", hl)
            .when()
            .get("/videoCategories"));
    }
}
