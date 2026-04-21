# language: es
@youtube @channels
Característica: Información de Canales de YouTube
  Como QA Automation Engineer
  Quiero validar el endpoint de canales
  Para asegurar que la información del canal es correcta

  Antecedentes:
    Dado que tengo acceso a la API de YouTube

  @youtube @channels @smoke
  Escenario: Obtener información de un canal conocido
    Cuando consulto el canal con ID "UCIkCzk3ezlAxX5r2OFlHLaQ"
    Entonces el código de respuesta es 200
    Y el canal tiene nombre y descripción
    Y las estadísticas del canal incluyen subscribers y videos


  Escenario: Validar schema de canal
    Cuando consulto el canal con ID "UCIkCzk3ezlAxX5r2OFlHLaQ" con partes "snippet,statistics,brandingSettings"
    Entonces el código de respuesta es 200
    Y el canal tiene imagen de perfil
    Y las estadísticas incluyen viewCount total

    
    
