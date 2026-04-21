# language: es
@youtube @videos
Característica: Detalle de Videos de YouTube
  Como QA Automation Engineer
  Quiero validar el endpoint de detalle de videos
  Para asegurar que la información del video es completa

  Antecedentes:
    Dado que tengo acceso a la API de YouTube

  @youtube @videos @smoke
  Escenario: Obtener detalle de un video conocido
    Cuando consulto el video con ID "9bZkp7q19f0"
    Entonces el código de respuesta es 200
    Y el video tiene título, descripción y canal
    Y las estadísticas incluyen vistas y likes

  Escenario: Validar schema completo de video
    Cuando consulto el video con ID "9bZkp7q19f0" con partes "snippet,statistics,contentDetails"
    Entonces el código de respuesta es 200
    Y el snippet contiene título, channelTitle y publishedAt
    Y las estadísticas contienen viewCount y likeCount
    Y el contentDetails contiene duración y definición

  @youtube @videos @negative
  Escenario: Video con ID inexistente retorna lista vacía
    Cuando consulto el video con ID "video_inexistente_xyz123"
    Entonces el código de respuesta es 200
    Y la respuesta no contiene videos

  Escenario: Validar que viewCount es un número válido como string
    Cuando consulto el video con ID "9bZkp7q19f0" con partes "statistics"
    Entonces el código de respuesta es 200
    Y el viewCount es un string numérico mayor a 0


