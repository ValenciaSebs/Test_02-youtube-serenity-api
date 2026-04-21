# Plantilla Coach - Serenity API YouTube

Base API del proyecto final con Serenity BDD + Cucumber + RestAssured sobre YouTube Data API v3.

## Objetivo

Dejar una plantilla lista para equipos que quieran una suite API con:

- features en Gherkin;
- step libraries reutilizables;
- reportes de Serenity;
- validaciones funcionales sobre búsqueda, videos, canales y categorías.

## Qué incluye

- `runners/` para ejecutar la suite.
- `stepdefinitions/` delgadas.
- `steps/` con acciones y validaciones reutilizables.
- `models/` para deserialización de respuestas.
- `features/` separadas por dominio funcional.

## Estructura útil

```text
src/test/resources/features/
  search/
  videos/
  channels/
  categories/
```

## Configuración

La API key puede venir de:

- `src/test/resources/serenity.conf`
- variable de entorno `YOUTUBE_API_KEY`
- system property `-Dyoutube.api.key=...`

Recomendación: no dejar la key real escrita en el repo.

## Ejecución

```bash
cd /Users/valen/OneDrive/Desktop/Kit Youtube/kit-youtube/plantillas/02_youtube_serenity_api/
mvn clean verify
```

Ejemplos:

```bash
mvn clean verify -Dcucumber.filter.tags="@youtube"
mvn clean verify -Dcucumber.filter.tags="not @smoke"
mvn clean verify -Dcucumber.features="src/test/resources/features/search/youtube_search.feature"
```

## Reporte

```bash
target/site/serenity/index.html
```
