Feature: Registro de ruta en actividades físicas
  Como usuario autenticado
  Quiero registrar y completar una actividad física
  Para hacer seguimiento de mi progreso

  Scenario Outline: Validación del flujo de actividad física
    Given el usuario ha iniciado sesión
    And está en la pantalla de actividades
    When inicia la actividad "<actividad>" desde la lista disponible
    Then la pantalla de seguimiento se muestra correctamente

    Examples:
      | actividad  |
      | run        |
    # run | walk | cyclism | hiking
