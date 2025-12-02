package org.calidadsoftware.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.calidadsoftware.questions.ToastVisible;
import org.calidadsoftware.questions.UsuarioEnLista;
import org.calidadsoftware.tasks.*;
import org.calidadsoftware.interfaces.FriendsPage;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class TwoStepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario-two");
    }

    @Given("está en la pantalla de amigos")
    public void enPantallaAmigos() {
        theActorInTheSpotlight().attemptsTo(
                NavegarFriends.go()
        );
    }

    @Given("está en la pantalla de amigos con alguna solicitud pendiente")
    public void amigoConSolicitud() {
        theActorInTheSpotlight().attemptsTo(
                NavegarFriendsAceptar.go()
        );
    }

    @Given("está en la pantalla de amigos con alguna amistad para eliminar")
    public void amigoParaEliminar() {
        theActorInTheSpotlight().attemptsTo(
                NavegarFriendsEliminar.go()
        );
    }

    @When("busca un usuario")
    public void buscaElUsuario() {
        theActorInTheSpotlight().attemptsTo(
                BuscarUsuario.conNombre(OnStage.theActorInTheSpotlight().recall("fakeEmail"))
        );
    }

    @When("presiona el botón de agregar amigo")
    public void presionaAgregarAmigo() {
        theActorInTheSpotlight().attemptsTo(
                AgregarAmigo.desdePerfil()
        );
    }

    @Then("se muestra el mensaje de confirmacion de envio de solicitud")
    public void seMuestraMensajeEnvioSolicitud() {
        theActorInTheSpotlight().should(
                seeThat(ToastVisible.encontrado(FriendsPage.ADD_MESSAGE_TOAST), equalTo(true))
        );
    }


    @When("presiona el botón de {string}")
    public void presionaAceptarSolicitud(String tipoAccion) {
        if (tipoAccion.equals("aceptar")) {
            theActorInTheSpotlight().attemptsTo(
                    AceptarSolicitud.deLaLista()
            );
        } else if (tipoAccion.equals("rechazar")) {
            theActorInTheSpotlight().attemptsTo(
                    RechazarSolicitud.deLaLista()
            );
        } else {
            throw new IllegalArgumentException("Acción no reconocida: " + tipoAccion);
        }
    }

    @Then("el usuario {string}")
    public void usuarioEnLista(String resultado) {
        if (resultado.equals("aparece en la lista de amigos")) {
            theActorInTheSpotlight().should(
                    seeThat(UsuarioEnLista.conNombre(OnStage.theActorInTheSpotlight().recall("fakeUsername")), equalTo(true))
            );
        } else if (resultado.equals("no aparece en la lista de amigos")) {
            theActorInTheSpotlight().should(
                    seeThat(UsuarioEnLista.conNombre(OnStage.theActorInTheSpotlight().recall("fakeUsername")), equalTo(false))
            );
        } else {
            throw new IllegalArgumentException("Resultado no reconocido: " + resultado);
        }
    }

    @When("presiona el botón de dejar de seguir")
    public void presionaDejarDeSeguir() {
        theActorInTheSpotlight().attemptsTo(
                EliminarAmigo.deLaBusqueda()
        );
    }

    @Then("el usuario ya no aparece en la lista de amigos")
    public void usuarioNoApareceEnLista() {
        theActorInTheSpotlight().should(
                seeThat(UsuarioEnLista.conNombre(OnStage.theActorInTheSpotlight().recall("fakeUsername")), equalTo(false))
        );
    }
}