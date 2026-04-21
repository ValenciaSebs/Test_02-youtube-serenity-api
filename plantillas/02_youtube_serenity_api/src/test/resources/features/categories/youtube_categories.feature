# language: es
@youtube @categories
Característica: Categorías de Videos de YouTube
  Como QA Automation Engineer
  Quiero validar el endpoint de categorías
  Para asegurar que la clasificación de videos es correcta

  Antecedentes:
    Dado que tengo acceso a la API de YouTube

  @youtube @categories @smoke
  Escenario: Comparar categorías entre regiones
    Cuando consulto las categorías para "CO" y para "US"
    Entonces ambas regiones comparten la categoría "Education"
