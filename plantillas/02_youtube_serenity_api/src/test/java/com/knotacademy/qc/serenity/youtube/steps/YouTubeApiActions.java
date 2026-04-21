package com.knotacademy.qc.serenity.youtube.steps;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

/**
 * Clase base para todas las step libraries de YouTube API.
 * Usa Serenity.getCurrentSession() para compartir la última respuesta
 * entre step libraries de acciones y assertions.
 *
 * Lectura de configuración: se lee directamente de serenity.conf
 * usando Typesafe Config (incluido como dependencia transitiva de Serenity).
 */
public class YouTubeApiActions {
    private static final String LAST_RESPONSE_KEY = "lastApiResponse";
    private static final Config config = ConfigFactory.load("serenity");

    protected String getBaseUrl() {
        return config.getString("environments.default.youtube.base.url");
    }

    protected String getApiKey() {
        String propertyApiKey = System.getProperty("youtube.api.key");
        if (propertyApiKey != null && !propertyApiKey.isBlank()) {
            return propertyApiKey;
        }

        String envApiKey = System.getenv("YOUTUBE_API_KEY");
        if (envApiKey != null && !envApiKey.isBlank()) {
            return envApiKey;
        }

        return config.getString("environments.default.youtube.api.key");
    }

    /**
     * Guarda la respuesta en la sesión de Serenity (compartida entre step libraries).
     */
    protected void saveResponse(Response response) {
        Serenity.getCurrentSession().put(LAST_RESPONSE_KEY, response);
    }

    /**
     * Obtiene la última respuesta guardada en la sesión de Serenity.
     * Es public para permitir acceso desde step definitions en otro paquete.
     */
    public Response getLastResponse() {
        return (Response) Serenity.getCurrentSession().get(LAST_RESPONSE_KEY);
    }
}
