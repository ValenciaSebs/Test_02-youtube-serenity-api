# Backlog Sugerido Y Convención De Tags

## Backlog Base

### Epic 1: Búsqueda Pública

- `YT-001`: buscar videos por palabra clave.
- `YT-002`: validar que la búsqueda devuelve resultados.
- `YT-003`: validar mínimo de resultados visibles o recibidos.

### Epic 2: Detalle De Video

- `YT-004`: abrir un video desde resultados.
- `YT-005`: validar título del video.
- `YT-006`: validar nombre del canal.

### Epic 3: Canales Y Metadata

- `YT-007`: consultar detalle de canal por API.
- `YT-008`: consultar detalle de video por API.
- `YT-009`: validar categorías o tipo de contenido.

### Epic 4: Robustez

- `YT-010`: validar respuesta ante request inválido.
- `YT-011`: ejecutar smoke en más de un navegador o entorno.
- `YT-012`: ejecutar smoke móvil si aplica.

## Tags Recomendados

### Por canal

- `@api`
- `@web`
- `@app`

### Por criticidad

- `@smoke`
- `@regression`
- `@negative`

### Por funcionalidad

- `@search`
- `@video`
- `@channel`
- `@categories`


### Por entrega o demo

- `@demo`
- `@scope_basico`
- `@scope_integrado`
- `@scope_avanzado`

## Ejemplos De Uso

### Ejemplo API

`@api @smoke @search @scope_basico`

### Ejemplo Web

`@web @regression @video @demo`

### Ejemplo App

`@app @smoke @playback @scope_avanzado`

## Evidencia Mínima Esperada

- ejecución local o por pipeline;
- reporte HTML o evidencia equivalente;
- feature o test nombrado con intención funcional;
- README con setup y comandos;
- explicación del alcance elegido y por qué.
