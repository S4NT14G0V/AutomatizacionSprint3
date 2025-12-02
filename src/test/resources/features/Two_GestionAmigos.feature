Feature: Gestión de amigos
  Como usuario autenticado
  Quiero gestionar mis amigos
  Para poder agregar o dejar de seguir a otros usuarios

  Scenario: Enviar solicitud de amistad
    Given el usuario ha iniciado sesión
    And está en la pantalla de amigos
    When busca un usuario
    And presiona el botón de agregar amigo
    Then se muestra el mensaje de confirmacion de envio de solicitud

  Scenario Outline: Aceptar solicitud de amistad
    Given el usuario ha iniciado sesión
    And está en la pantalla de amigos con alguna solicitud pendiente
    When busca un usuario
    And presiona el botón de "<tipo_accion>"
    Then el usuario "<resultado>"

    Examples:
      | tipo_accion | resultado                        |
      | aceptar     | aparece en la lista de amigos    |
      | rechazar    | no aparece en la lista de amigos |

  Scenario: Eliminar un amigo existente
    Given el usuario ha iniciado sesión
    And está en la pantalla de amigos con alguna amistad para eliminar
    When busca un usuario
    And presiona el botón de dejar de seguir
    Then el usuario ya no aparece en la lista de amigos