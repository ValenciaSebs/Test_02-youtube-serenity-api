# language: es
@youtube @search
Característica: Búsqueda de Videos en YouTube
  Como QA Automation Engineer
  Quiero validar el endpoint de búsqueda de YouTube
  Para asegurar que la API devuelve resultados correctos

  Antecedentes:
    Dado que tengo acceso a la API de YouTube

  @youtube @videos @smoke
  Escenario: Buscar videos por palabra clave
    Cuando busco videos con el término "ecuaciones"
    Entonces el código de respuesta es 200
    Y la respuesta contiene al menos 1 resultado
    Y cada resultado tiene un título válido
    Y cada resultado tiene un ID de video

  Escenario: Validar schema completo de búsqueda
    Cuando busco videos con el término "factorización"
    Entonces el código de respuesta es 200
    Y cada resultado contiene los campos obligatorios de snippet
    Y el pageInfo indica el total de resultados

  Esquema del escenario: Buscar videos por diferentes temas de QA
    Cuando busco videos con el término "<tema>"
    Entonces el código de respuesta es 200
    Y la respuesta contiene al menos 1 resultado

    Ejemplos:
      | tema                    |
      | karate api testing      |
      | cucumber bdd español    |
      | appium mobile testing   |
      | serenity bdd tutorial   |

  @youtube @videos @negative
  Escenario: Búsqueda con query vacío retorna error
    Cuando busco videos con el término ""
    Entonces el código de respuesta es 200

  Escenario: Validar paginación de búsqueda
    Cuando busco videos con el término "automation" y máximo 2 resultados
    Entonces el código de respuesta es 200
    Y la respuesta incluye un token de siguiente página

 
