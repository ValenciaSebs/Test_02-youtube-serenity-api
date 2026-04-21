package com.knotacademy.qc.serenity.youtube.steps;

import com.knotacademy.qc.serenity.youtube.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Step library de assertions para YouTube API.
 * Lee la respuesta compartida desde Serenity session via getLastResponse().
 */
public class YouTubeAssertions extends YouTubeApiActions {
    private final ObjectMapper objectMapper = new ObjectMapper();

    // ==================== STATUS CODE ====================

    @Step("Verificar que el código de respuesta es {0}")
    public void verificarStatusCode(int expectedCode) {
        assertThat(getLastResponse().getStatusCode())
            .as("El código de respuesta debe ser " + expectedCode)
            .isEqualTo(expectedCode);
    }

    // ==================== RESULTADOS GENERICOS ====================

    @Step("Verificar que la respuesta contiene al menos {0} resultado(s)")
    public void verificarAlMenosNResultados(int minResults) {
        List<?> items = getLastResponse().jsonPath().getList("items");
        assertThat(items)
            .as("Debe haber al menos " + minResults + " resultado(s)")
            .isNotNull()
            .hasSizeGreaterThanOrEqualTo(minResults);
    }

    @Step("Verificar que la respuesta contiene exactamente {0} resultado(s)")
    public void verificarExactamenteNResultados(int expectedCount) {
        List<?> items = getLastResponse().jsonPath().getList("items");
        assertThat(items)
            .as("Debe haber exactamente " + expectedCount + " resultado(s)")
            .hasSize(expectedCount);
    }

    @Step("Verificar que la respuesta no contiene resultados")
    public void verificarSinResultados() {
        List<?> items = getLastResponse().jsonPath().getList("items");
        if (items == null) return; // null means no items key
        assertThat(items)
            .as("No debe haber resultados")
            .isEmpty();
    }

    private VideoResponse.VideoItem primerVideo(VideoResponse vr) {
        assertThat(vr.getItems())
            .as("La respuesta debe contener al menos un video")
            .isNotNull()
            .isNotEmpty();
        return vr.getItems().get(0);
    }

    // ==================== SEARCH ASSERTIONS ====================

    @Step("Verificar que cada resultado tiene un título válido")
    public void verificarTitulosValidos() {
        try {
            SearchResponse sr = objectMapper.readValue(
                getLastResponse().getBody().asString(), SearchResponse.class);
            assertThat(sr.getItems())
                .isNotEmpty()
                .allMatch(item -> item.getSnippet() != null &&
                         item.getSnippet().getTitle() != null &&
                         !item.getSnippet().getTitle().isEmpty(),
                    "Todos los títulos deben ser válidos");
        } catch (Exception e) {
            throw new AssertionError("Error al deserializar respuesta de búsqueda: " + e.getMessage());
        }
    }

    @Step("Verificar que cada resultado tiene un ID de video")
    public void verificarIdsVideos() {
        try {
            SearchResponse sr = objectMapper.readValue(
                getLastResponse().getBody().asString(), SearchResponse.class);
            assertThat(sr.getItems())
                .allMatch(item -> item.getId() != null && item.getId().getVideoId() != null,
                    "Todos los resultados deben tener un ID de video");
        } catch (Exception e) {
            throw new AssertionError("Error al deserializar respuesta: " + e.getMessage());
        }
    }

    @Step("Verificar que cada resultado contiene los campos obligatorios de snippet")
    public void verificarCamposSnippet() {
        try {
            SearchResponse sr = objectMapper.readValue(
                getLastResponse().getBody().asString(), SearchResponse.class);
            assertThat(sr.getItems())
                .allMatch(item -> item.getSnippet() != null &&
                         item.getSnippet().getTitle() != null &&
                         item.getSnippet().getChannelId() != null &&
                         item.getSnippet().getChannelTitle() != null,
                    "Todos los items deben tener snippet con campos obligatorios");
        } catch (Exception e) {
            throw new AssertionError("Error validando campos: " + e.getMessage());
        }
    }

    @Step("Verificar que pageInfo indica el total de resultados")
    public void verificarPageInfo() {
        try {
            SearchResponse sr = objectMapper.readValue(
                getLastResponse().getBody().asString(), SearchResponse.class);
            assertThat(sr.getPageInfo())
                .isNotNull()
                .extracting("totalResults")
                .isNotNull();
        } catch (Exception e) {
            throw new AssertionError("Error validando pageInfo: " + e.getMessage());
        }
    }

    @Step("Verificar que la respuesta contiene resultados ordenados")
    public void verificarResultadosOrdenados() {
        assertThat(getLastResponse().jsonPath().getList("items"))
            .isNotEmpty();
    }

    @Step("Verificar que la respuesta incluye un token de siguiente página")
    public void verificarTokenPaginacion() {
        String nextPageToken = getLastResponse().jsonPath().getString("nextPageToken");
        assertThat(nextPageToken)
            .as("Debe existir un token de siguiente página")
            .isNotNull()
            .isNotEmpty();
    }

    @Step("Verificar que cada resultado es de tipo {0}")
    public void verificarTipoResultado(String type) {
        try {
            SearchResponse sr = objectMapper.readValue(
                getLastResponse().getBody().asString(), SearchResponse.class);
            assertThat(sr.getItems())
                .allMatch(item -> type.equals(item.getId().getKind()),
                    "Todos los resultados deben ser de tipo " + type);
        } catch (Exception e) {
            throw new AssertionError("Error validando tipo: " + e.getMessage());
        }
    }

    // ==================== VIDEO ASSERTIONS ====================

    @Step("Verificar que el video tiene título, descripción y canal")
    public void verificarDatosBasicosVideo() {
        try {
            VideoResponse vr = objectMapper.readValue(
                getLastResponse().getBody().asString(), VideoResponse.class);
            assertThat(vr.getItems())
                .isNotEmpty()
                .allMatch(item -> item.getSnippet() != null &&
                         item.getSnippet().getTitle() != null &&
                         item.getSnippet().getChannelTitle() != null,
                    "El video debe tener título y canal");
        } catch (Exception e) {
            throw new AssertionError("Error validando datos del video: " + e.getMessage());
        }
    }

    @Step("Verificar que las estadísticas incluyen vistas y likes")
    public void verificarEstadisticasVideo() {
        try {
            VideoResponse vr = objectMapper.readValue(
                getLastResponse().getBody().asString(), VideoResponse.class);
            assertThat(vr.getItems())
                .allMatch(item -> item.getStatistics() != null &&
                         item.getStatistics().getViewCount() != null,
                    "Las estadísticas deben incluir viewCount");
        } catch (Exception e) {
            throw new AssertionError("Error validando estadísticas: " + e.getMessage());
        }
    }

    @Step("Verificar que el snippet contiene título, channelTitle y publishedAt")
    public void verificarCamposSnippetVideo() {
        try {
            VideoResponse vr = objectMapper.readValue(
                getLastResponse().getBody().asString(), VideoResponse.class);
            VideoResponse.VideoItem item = primerVideo(vr);
            assertThat(item.getSnippet())
                .isNotNull()
                .extracting("title", "channelTitle", "publishedAt")
                .doesNotContainNull();
        } catch (Exception e) {
            throw new AssertionError("Error validando campos snippet: " + e.getMessage());
        }
    }

    @Step("Verificar que las estadísticas contienen viewCount y likeCount")
    public void verificarCamposEstadisticasVideo() {
        try {
            VideoResponse vr = objectMapper.readValue(
                getLastResponse().getBody().asString(), VideoResponse.class);
            VideoResponse.VideoItem item = primerVideo(vr);
            assertThat(item.getStatistics())
                .isNotNull()
                .extracting("viewCount")
                .isNotNull();
        } catch (Exception e) {
            throw new AssertionError("Error validando campos estadísticas: " + e.getMessage());
        }
    }

    @Step("Verificar que el contentDetails contiene duración y definición")
    public void verificarCamposContentDetails() {
        try {
            VideoResponse vr = objectMapper.readValue(
                getLastResponse().getBody().asString(), VideoResponse.class);
            VideoResponse.VideoItem item = primerVideo(vr);
            assertThat(item.getContentDetails())
                .isNotNull()
                .extracting("duration")
                .isNotNull();
        } catch (Exception e) {
            throw new AssertionError("Error validando contentDetails: " + e.getMessage());
        }
    }

    @Step("Verificar que viewCount es un string numérico mayor a {0}")
    public void verificarViewCountValido(int minValue) {
        try {
            VideoResponse vr = objectMapper.readValue(
                getLastResponse().getBody().asString(), VideoResponse.class);
            VideoResponse.VideoItem item = primerVideo(vr);
            String viewCount = item.getStatistics().getViewCount();
            assertThat(viewCount).isNotNull().matches("\\d+");
            assertThat(Long.parseLong(viewCount)).isGreaterThan(minValue);
        } catch (Exception e) {
            throw new AssertionError("Error validando viewCount: " + e.getMessage());
        }
    }

    @Step("Verificar que la duración tiene formato ISO 8601")
    public void verificarFormatoIso8601() {
        try {
            VideoResponse vr = objectMapper.readValue(
                getLastResponse().getBody().asString(), VideoResponse.class);
            String duration = primerVideo(vr).getContentDetails().getDuration();
            assertThat(duration)
                .isNotNull()
                .matches("PT(\\d+H)?(\\d+M)?(\\d+S)?");
        } catch (Exception e) {
            throw new AssertionError("Error validando formato ISO 8601: " + e.getMessage());
        }
    }

    @Step("Verificar que la respuesta contiene solo datos de snippet sin estadísticas")
    public void verificarSoloSnippet() {
        try {
            VideoResponse vr = objectMapper.readValue(
                getLastResponse().getBody().asString(), VideoResponse.class);
            VideoResponse.VideoItem item = primerVideo(vr);
            assertThat(item.getSnippet()).isNotNull();
            assertThat(item.getStatistics()).isNull();
        } catch (Exception e) {
            throw new AssertionError("Error validando que solo contiene snippet: " + e.getMessage());
        }
    }

    // ==================== CHANNEL ASSERTIONS ====================

    @Step("Verificar que el canal tiene nombre y descripción")
    public void verificarDatosBasicosCanal() {
        try {
            ChannelResponse cr = objectMapper.readValue(
                getLastResponse().getBody().asString(), ChannelResponse.class);
            assertThat(cr.getItems())
                .isNotEmpty()
                .allMatch(item -> item.getSnippet() != null &&
                         item.getSnippet().getTitle() != null,
                    "El canal debe tener nombre");
        } catch (Exception e) {
            throw new AssertionError("Error validando datos del canal: " + e.getMessage());
        }
    }

    @Step("Verificar que las estadísticas del canal incluyen subscribers y videos")
    public void verificarEstadisticasCanal() {
        try {
            ChannelResponse cr = objectMapper.readValue(
                getLastResponse().getBody().asString(), ChannelResponse.class);
            assertThat(cr.getItems())
                .allMatch(item -> item.getStatistics() != null &&
                         item.getStatistics().getSubscriberCount() != null &&
                         item.getStatistics().getVideoCount() != null,
                    "Las estadísticas deben incluir subscribers y video count");
        } catch (Exception e) {
            throw new AssertionError("Error validando estadísticas del canal: " + e.getMessage());
        }
    }

    @Step("Verificar que el canal tiene imagen de perfil")
    public void verificarImagenPerfil() {
        try {
            ChannelResponse cr = objectMapper.readValue(
                getLastResponse().getBody().asString(), ChannelResponse.class);
            assertThat(cr.getItems())
                .allMatch(item -> item.getSnippet() != null,
                    "El canal debe tener snippet con thumbnail");
        } catch (Exception e) {
            throw new AssertionError("Error validando imagen: " + e.getMessage());
        }
    }

    @Step("Verificar que las estadísticas incluyen viewCount total")
    public void verificarViewCountCanal() {
        try {
            ChannelResponse cr = objectMapper.readValue(
                getLastResponse().getBody().asString(), ChannelResponse.class);
            assertThat(cr.getItems().get(0).getStatistics().getViewCount())
                .isNotNull();
        } catch (Exception e) {
            throw new AssertionError("Error validando viewCount del canal: " + e.getMessage());
        }
    }

    @Step("Verificar que subscriberCount es un string numérico mayor a {0}")
    public void verificarSubscriberCountValido(int minValue) {
        try {
            ChannelResponse cr = objectMapper.readValue(
                getLastResponse().getBody().asString(), ChannelResponse.class);
            String subCount = cr.getItems().get(0).getStatistics().getSubscriberCount();
            assertThat(subCount).isNotNull().matches("\\d+");
            assertThat(Long.parseLong(subCount)).isGreaterThan(minValue);
        } catch (Exception e) {
            throw new AssertionError("Error validando subscriberCount: " + e.getMessage());
        }
    }

    // ==================== CATEGORY ASSERTIONS ====================

    @Step("Verificar que la respuesta contiene al menos {0} categorías")
    public void verificarAlMenosCategorias(int minCount) {
        List<?> items = getLastResponse().jsonPath().getList("items");
        assertThat(items)
            .isNotNull()
            .hasSizeGreaterThanOrEqualTo(minCount);
    }

    @Step("Verificar que cada categoría tiene ID y nombre")
    public void verificarCamposCategorias() {
        try {
            CategoryResponse cr = objectMapper.readValue(
                getLastResponse().getBody().asString(), CategoryResponse.class);
            assertThat(cr.getItems())
                .isNotNull()
                .allMatch(item -> item.getId() != null &&
                         item.getSnippet() != null &&
                         item.getSnippet().getTitle() != null,
                    "Cada categoría debe tener ID y nombre");
        } catch (Exception e) {
            throw new AssertionError("Error validando campos de categorías: " + e.getMessage());
        }
    }

    @Step("Verificar que la categoría {0} está presente en la respuesta")
    public void verificarCategoriaPresente(String categoryName) {
        try {
            CategoryResponse cr = objectMapper.readValue(
                getLastResponse().getBody().asString(), CategoryResponse.class);
            List<CategoryResponse.CategoryItem> catItems = cr.getItems();
            assertThat(catItems)
                .as("La respuesta debe contener items de categorías")
                .isNotNull();
            boolean found = catItems.stream()
                .anyMatch(item -> item.getSnippet() != null &&
                         categoryName.equalsIgnoreCase(item.getSnippet().getTitle()));
            assertThat(found)
                .as("La categoría '" + categoryName + "' debe estar presente")
                .isTrue();
        } catch (Exception e) {
            throw new AssertionError("Error validando categoría: " + e.getMessage());
        }
    }
}
