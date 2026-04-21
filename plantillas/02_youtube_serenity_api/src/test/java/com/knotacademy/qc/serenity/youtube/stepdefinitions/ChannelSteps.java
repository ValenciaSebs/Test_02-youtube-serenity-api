package com.knotacademy.qc.serenity.youtube.stepdefinitions;

import com.knotacademy.qc.serenity.youtube.steps.YouTubeChannelActions;
import com.knotacademy.qc.serenity.youtube.steps.YouTubeAssertions;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;

public class ChannelSteps {
    @Steps
    private YouTubeChannelActions channelActions;

    @Steps
    private YouTubeAssertions assertions;

    // ==================== CUANDO ====================

    @Cuando("consulto el canal con ID {string}")
    public void consultarCanal(String channelId) {
        channelActions.consultarCanal(channelId);
    }

    @Cuando("consulto el canal con ID {string} con partes {string}")
    public void consultarCanalConPartes(String channelId, String parts) {
        channelActions.consultarCanalConPartes(channelId, parts);
    }

    @Cuando("consulto los canales {string}")
    public void consultarMultiplesCanales(String channelIds) {
        channelActions.consultarMultiplesCanales(channelIds);
    }

    // ==================== ENTONCES ====================
    // NOTA: "el código de respuesta es {int}" está en CommonSteps

    @Entonces("el canal tiene nombre y descripción")
    public void verificarDatosBasicosCanal() {
        assertions.verificarDatosBasicosCanal();
    }

    @Entonces("las estadísticas del canal incluyen subscribers y videos")
    public void verificarEstadisticasCanal() {
        assertions.verificarEstadisticasCanal();
    }

    @Entonces("el canal tiene imagen de perfil")
    public void verificarImagenPerfil() {
        assertions.verificarImagenPerfil();
    }

    @Entonces("las estadísticas incluyen viewCount total")
    public void verificarViewCountCanal() {
        assertions.verificarViewCountCanal();
    }

    @Entonces("la respuesta no contiene canales")
    public void verificarSinCanales() {
        assertions.verificarSinResultados();
    }

    @Entonces("la respuesta contiene al menos {int} canal")
    public void verificarAlMenosUnCanal(int minCount) {
        assertions.verificarAlMenosNResultados(minCount);
    }

    @Entonces("el subscriberCount es un string numérico mayor a {int}")
    public void verificarSubscriberCountValido(int minValue) {
        assertions.verificarSubscriberCountValido(minValue);
    }
}
