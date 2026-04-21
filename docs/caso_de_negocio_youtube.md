# Caso De Negocio: Validación Multicanal De Contenido En YouTube

## Contexto

Un área de contenidos y formación digital publica material técnico en YouTube para atraer estudiantes, fortalecer marca y aumentar consumo de cursos. El equipo necesita comprobar que el contenido público se pueda descubrir, consultar y navegar de forma consistente en API, Web y, si el alcance lo permite, App móvil.

## Problema

Hoy no existe una suite automatizada que confirme de forma recurrente si:

- las búsquedas públicas devuelven contenido relevante;
- los videos y canales oficiales son visibles;
- la metadata consultada por API coincide con lo esperado;
- la experiencia pública básica funciona en navegador y móvil.

Esto genera riesgo en demo, regresiones visibles y poca trazabilidad para el equipo.

## Objetivo Del Proyecto Final

Construir una solución de automatización que permita validar flujos públicos de YouTube con uno o varios canales:

- API
- Web
- App móvil

La solución debe ser demostrable, mantenible y entendible por el grupo que la presenta.

## Stakeholders

- Líder de QA: necesita una base automatizada reusable.
- Líder de contenidos: necesita verificar que videos y canales oficiales se encuentran fácilmente.
- Instructor o coach: necesita una demo clara, trazable y portable al portafolio del estudiante.

## Alcance Funcional Base

Los grupos pueden modelar uno o varios de estos flujos:

1. Buscar contenido por palabra clave.
2. Validar que existen resultados.
3. Abrir un video y verificar información principal.
4. Navegar al canal asociado.
5. Consultar detalles por API.
6. Validar categorías o listados de videos.
7. Ejecutar smoke móvil en la app.

## Reglas Del Negocio

- El proyecto debe usar contenido público, sin depender de cuentas personales del estudiante.
- Se deben evitar flujos frágiles con login, suscripciones, comentarios o anuncios obligatorios.
- La suite debe priorizar flujos estables y demostrables en clase.
- Los tags deben permitir filtrar por canal, prioridad y funcionalidad.

## Fuera De Alcance Recomendado

- Login con cuenta Google.
- Suscribirse a canales reales.
- Comentarios, likes y monetización.
- Recomendaciones personalizadas.
- Validaciones basadas en ranking exacto del primer resultado.

## Viajes De Usuario Sugeridos

### Viaje 1: Descubrimiento De Contenido

Como usuario interesado en QA Automation, quiero buscar contenido técnico en YouTube para encontrar videos y canales relevantes.

### Viaje 2: Consulta De Detalle

Como usuario, quiero abrir un video y validar su título, canal y disponibilidad para confirmar que el contenido es el esperado.

### Viaje 3: Consistencia De Metadata

Como QA, quiero consultar la API de YouTube para validar que la información pública de videos y canales responde correctamente.

### Viaje 4: Acceso Desde Móvil

Como usuario móvil, quiero abrir la app, buscar un término y entrar a un video para confirmar que el flujo básico funciona.

## Criterios De Aceptación Base

- La suite ejecuta al menos un flujo real del alcance escogido.
- El proyecto tiene README, instrucciones de ejecución y tags definidos.
- El equipo puede explicar qué riesgo de negocio mitiga cada prueba.
- La demo muestra evidencia clara de ejecución y resultado.
