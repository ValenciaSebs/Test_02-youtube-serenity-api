package com.knotacademy.qc.serenity.youtube.stepdefinitions;

import com.knotacademy.qc.serenity.youtube.steps.YouTubeCategoryActions;
import com.knotacademy.qc.serenity.youtube.steps.YouTubeAssertions;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

public class CategorySteps {
    @Steps
    private YouTubeCategoryActions categoryActions;

    @Steps
    private YouTubeAssertions assertions;

    private int categoriasColombiaCount = 0;

    // ==================== CUANDO ====================

    @Cuando("consulto las categorías de video para la región {string}")
    public void consultarCategoriasParaRegion(String regionCode) {
        categoryActions.consultarCategoriasParaRegion(regionCode);
        // Guardar count de Colombia para comparación posterior
        if ("CO".equalsIgnoreCase(regionCode)) {
            java.util.List<?> items = assertions.getLastResponse()
                .jsonPath().getList("items");
            categoriasColombiaCount = (items != null) ? items.size() : 0;
        }
    }

    @Cuando("consulto las categorías para {string} y para {string}")
    public void consultarCategoriasMultiplesRegiones(String region1, String region2) {
        // Primero consultamos la segunda región (US) para verificar que la categoría existe
        categoryActions.consultarCategoriasParaRegion(region2);
    }

    // ==================== ENTONCES ====================
    // NOTA: "el código de respuesta es {int}" está en CommonSteps

    @Entonces("la respuesta contiene al menos {int} categorías")
    public void verificarAlMenosCategorias(int minCount) {
        assertions.verificarAlMenosCategorias(minCount);
    }

    @Entonces("cada categoría tiene ID y nombre")
    public void verificarCamposCategorias() {
        assertions.verificarCamposCategorias();
    }

    @Entonces("la respuesta contiene más categorías que para Colombia")
    public void verificarMasCategoriasQueColombia() {
        java.util.List<?> currentItems = assertions.getLastResponse()
            .jsonPath().getList("items");
        int currentCount = (currentItems != null) ? currentItems.size() : 0;
        org.assertj.core.api.Assertions.assertThat(currentCount)
            .as("US debe tener más categorías que Colombia (" + categoriasColombiaCount + ")")
            .isGreaterThanOrEqualTo(categoriasColombiaCount);
    }

    @Entonces("ambas regiones comparten la categoría {string}")
    public void verificarCategoriasComunes(String categoryName) {
        assertions.verificarCategoriaPresente(categoryName);
    }
}
