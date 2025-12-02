Feature: Gestión de amigos
  Como usuario autenticado
  Quiero gestionar mis amigos
  Para poder agregar o dejar de seguir a otros usuarios

  Scenario: Enviar solicitud de amistad
    Given el usuario ha iniciado sesión con correo "santiago.tbolivar@udea.edu.co" y contraseña "123456S$"
    And está en la pantalla de amigos
    When busca el usuario "santiago"
    And presiona el botón de agregar amigo
    Then se muestra el mensaje de confirmacion de envio de solicitud

  Scenario: Aceptar solicitud de amistad
    Given el usuario ha iniciado sesión con correo "santiago.tbolivar2@udea.edu.co" y contraseña "123456S$"
    And está en la pantalla de amigos
    When busca el usuario "teste2etest2"
    And presiona el botón de aceptar solicitud
    Then el usuario aparece en la lista de amigos

  Scenario: Eliminar un amigo existente
    Given el usuario ha iniciado sesión con correo "santiago.tbolivar@udea.edu.co" y contraseña "123456S$"
    And está en la pantalla de amigos
    When busca el usuario "santiago"
    And presiona el botón de dejar de seguir
    Then el usuario ya no aparece en la lista de amigos
