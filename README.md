# Kit Proyecto Final YouTube

Repositorio base para trabajar el proyecto final del curso usando YouTube como dominio funcional. El kit está organizado por plantillas independientes para API, Web, Screenplay y Mobile, más una carpeta `docs/` con el contexto del caso.

## Estructura principal

| Ruta | Stack | Uso recomendado | Estado |
|---|---|---|---|
| `plantillas/01_youtube_karate` | Karate | API rápida y simple | lista |
| `plantillas/02_youtube_serenity_api` | Serenity + Cucumber | API con BDD y reportes ejecutivos | lista |
| `plantillas/03_youtube_serenity_screenplay` | Serenity + Screenplay | base integrada API + Web + App | lista para API/Web, App requiere mantenimiento según versión de YouTube |
| `plantillas/04_youtube_selenium_web` | Selenium + POM | Web clásica con JUnit | lista |
| `plantillas/05_youtube_appium` | Appium + JUnit | base mobile más estable para Android | lista |
| `plantillas/03_youtube_serenity_screenplay_web` | Serenity + Screenplay Web | variante web simplificada | referencia opcional |
| `docs/` | guías del kit | alcance, backlog, demo y caso de negocio | lista |

No existe una carpeta `dogs` en este repositorio. La carpeta funcional de apoyo es `docs/`.

## Cómo elegir una plantilla

- Si solo quieres API y velocidad: usa `01_youtube_karate`.
- Si quieres API con Cucumber y living documentation: usa `02_youtube_serenity_api`.
- Si quieres Web simple y directa: usa `04_youtube_selenium_web`.
- Si quieres Mobile: usa `05_youtube_appium`.
- Si quieres una arquitectura avanzada con actor, tasks, abilities y varios canales: usa `03_youtube_serenity_screenplay`.

## Orden recomendado de uso

1. Lee [docs/caso_de_negocio_youtube.md](/Users/arnold/Desktop/qa/kit_proyecto_final_youtube/docs/caso_de_negocio_youtube.md).
2. Revisa [docs/matriz_de_alcances_y_repos.md](/Users/arnold/Desktop/qa/kit_proyecto_final_youtube/docs/matriz_de_alcances_y_repos.md).
3. Elige una sola plantilla como base principal.
4. Configura credenciales y propiedades locales.
5. Ejecuta primero el smoke mínimo de esa plantilla.
6. Extiende solo los escenarios que sí vas a presentar.

## Requisitos generales

- Java 17+
- Maven 3.8+
- Acceso a internet para pruebas contra YouTube
- API key de YouTube Data API v3 para proyectos API
- Chrome o Firefox para proyectos Web
- Android SDK, Appium 2 y emulador/dispositivo para Mobile

## Comandos rápidos

### 01 Karate

```bash
cd plantillas/01_youtube_karate
mvn test
```

### 02 Serenity API

```bash
cd plantillas/02_youtube_serenity_api
mvn clean verify
```

### 03 Screenplay

```bash
cd plantillas/03_youtube_serenity_screenplay
mvn -Papi test
mvn -Pweb test
mvn -Papp test
```

### 04 Selenium Web

```bash
cd plantillas/04_youtube_selenium_web
mvn test
```

### 05 Appium

```bash
cd plantillas/05_youtube_appium
mvn -Dplatform=android test
```

## Arquitectura y buenas prácticas

- Cada plantilla debe seguir el patrón de su stack y no mezclar estilos de automatización sin motivo.
- La configuración sensible no debe quedar hardcodeada en el repo.
- Los locators deben vivir en `pages/` o `screens/`, no en los tests.
- Los steps de Cucumber deben ser delgados; la lógica reusable debe ir en step libraries, tasks o questions.
- Los tests smoke deben ser cortos, estables y útiles como validación base del proyecto.
- Los artefactos generados no deben versionarse: `target/`, `allure-results/`, salidas temporales y reportes locales.
- Si YouTube cambia su DOM o su UI mobile, se corrige el objeto de página afectado, no los tests completos.

## Qué revisar antes de publicar

- Actualizar nombres de proyecto, `artifactId` y descripciones si el equipo lo necesita.
- Revisar que no haya API keys reales en archivos versionados.
- Confirmar que `.gitignore` cubre artefactos generados.
- Ejecutar al menos el smoke de la plantilla elegida.
- Borrar reportes locales y salidas temporales antes del primer commit público.
- Documentar en el README del módulo cualquier limitación conocida.

## Documentación de apoyo

- [docs/caso_de_negocio_youtube.md](/Users/arnold/Desktop/qa/kit_proyecto_final_youtube/docs/caso_de_negocio_youtube.md)
- [docs/matriz_de_alcances_y_repos.md](/Users/arnold/Desktop/qa/kit_proyecto_final_youtube/docs/matriz_de_alcances_y_repos.md)
- [docs/backlog_y_tags.md](/Users/arnold/Desktop/qa/kit_proyecto_final_youtube/docs/backlog_y_tags.md)
- [docs/guia_de_presentacion_final.md](/Users/arnold/Desktop/qa/kit_proyecto_final_youtube/docs/guia_de_presentacion_final.md)

## Nota sobre la plantilla 03

`03_youtube_serenity_screenplay` es la plantilla más potente pero también la más sensible a cambios de YouTube, sobre todo en Appium. Si el objetivo es publicar una base mobile más estable, hoy conviene priorizar `05_youtube_appium` y usar el canal app de la 03 como referencia avanzada.