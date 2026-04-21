# Matriz De Alcances Y Repos

## Ruta recomendada

No todos los grupos deben construir lo mismo. La idea es elegir un alcance coherente con el tiempo, el tamaño del equipo y el nivel técnico.

| Alcance | Stack sugerido | Repo base | Qué demuestra |
|---|---|---|---|
| API básico | Karate | `plantillas/01_youtube_karate` | requests, validaciones JSON, tags y smoke |
| API documentado | Serenity + Cucumber | `plantillas/02_youtube_serenity_api` | BDD, living documentation y step libraries |
| Web básico | Selenium + POM | `plantillas/04_youtube_selenium_web` | navegación web, page objects y waits |
| Mobile básico | Appium | `plantillas/05_youtube_appium` | setup móvil, búsqueda y playback smoke |
| Integrado avanzado | Serenity + Screenplay | `plantillas/03_youtube_serenity_screenplay` | actor, task, ability, question y varios canales |

## Combinaciones sugeridas

### Opción A: un solo repo

- `01_youtube_karate` si el grupo quiere enfocarse solo en API.
- `04_youtube_selenium_web` si el grupo quiere enfocarse solo en Web.
- `05_youtube_appium` si el grupo quiere asumir el reto Mobile.

### Opción B: dos repos

- `01_youtube_karate` + `04_youtube_selenium_web`
- `02_youtube_serenity_api` + `04_youtube_selenium_web`
- `04_youtube_selenium_web` + `05_youtube_appium`

### Opción C: un repo integrador

- `03_youtube_serenity_screenplay` para quienes quieran presentar API + Web bajo Screenplay.
- `03_youtube_serenity_screenplay` más `05_youtube_appium` si el grupo quiere ampliar el alcance móvil sin forzar todo dentro de la plantilla integrada.

## Recomendación por tamaño de grupo

| Tamaño del grupo | Recomendación |
|---|---|
| 1 persona | un solo repo |
| 2 personas | uno o dos repos con responsabilidades separadas |
| 3 o más personas | API + Web o repo integrador con reparto por canal |

## Criterio para elegir

- Si quieren velocidad: `01_youtube_karate`.
- Si quieren una demo más ejecutiva: `02_youtube_serenity_api`.
- Si quieren reforzar automatización UI clásica: `04_youtube_selenium_web`.
- Si quieren arquitectura avanzada: `03_youtube_serenity_screenplay`.
- Si quieren una base mobile más directa: `05_youtube_appium`.

## Nota práctica

Hoy `03_youtube_serenity_screenplay` funciona mejor como base avanzada para API y Web. Para Mobile, la opción más limpia para publicar y continuar es `05_youtube_appium`.
