Feature: Actualización de perfil de usuario
  Como usuario autenticado
  Quiero actualizar la información de mi perfil
  Para mantener mis datos personales correctos y actualizados

  # Escenario 1: camino feliz
  Scenario: Actualización exitosa del perfil con datos válidos
    Given el usuario ha iniciado sesión
    And está en la pantalla de edición de perfil
    When modifica su nombre de usuario a "teste2etest2" y su nombre completo a "Juan Perez"
    Then es redirigido a la pantalla de perfil
    And visualiza los datos actualizados correctamente

  # Escenario 2: camino excepcional
  Scenario Outline: Fallo en la actualización por datos inválidos
    Given el usuario ha iniciado sesión
    And está en la pantalla de edición de perfil
    When modifica su nombre de usuario a "<username>" y su nombre completo a "<fullname>"
    Then se muestra el mensaje de error

    Examples:
      | username | fullname   |
      | santiago | Juan Perez |
      |          | Juan Perez |
      | teste1   |            |