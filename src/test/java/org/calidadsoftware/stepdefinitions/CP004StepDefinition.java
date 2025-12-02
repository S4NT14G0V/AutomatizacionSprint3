package org.calidadsoftware.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.calidadsoftware.models.UserCredentials;
import org.calidadsoftware.questions.ToastVisible;
import org.calidadsoftware.questions.UsuarioEnLista;
import org.calidadsoftware.tasks.AceptarSolicitud;
import org.calidadsoftware.tasks.AgregarAmigo;
import org.calidadsoftware.tasks.BuscarUsuario;
import org.calidadsoftware.tasks.EliminarAmigo;
import org.calidadsoftware.tasks.IniciarSesion;
import org.calidadsoftware.tasks.NavegarFriends;
import org.calidadsoftware.interfaces.FriendsPage;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class CP004StepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario-CP004");
    }

    private String ultimoUsuarioBuscado;

    @Given("el usuario ha iniciado sesión")
    public void usuarioLogueadoConCredenciales(String correo, String contrasena) {
        theActorInTheSpotlight().attemptsTo(
                IniciarSesion.conCredenciales(new UserCredentials(correo, contrasena))
        );
    }

    @Given("está en la pantalla de amigos")
    public void enPantallaPerfil() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarFriends.go()
        );
    }
    @When("busca el usuario {string}")
    public void buscaElUsuario(String username) {
        this.ultimoUsuarioBuscado = username;
        theActorInTheSpotlight().attemptsTo(
                BuscarUsuario.conNombre(username)
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


    @When("presiona el botón de aceptar solicitud")
    public void presionaAceptarSolicitud() {
        theActorInTheSpotlight().attemptsTo(
                AceptarSolicitud.deLaLista()
        );
    }

    @Then("el usuario aparece en la lista de amigos")
    public void usuarioApareceEnLista() {
        theActorInTheSpotlight().should(
                // usar el usuario guardado en vez de un valor hardcodeado
                seeThat(UsuarioEnLista.conNombre(ultimoUsuarioBuscado), equalTo(true))
        );
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
                seeThat(UsuarioEnLista.conNombre(ultimoUsuarioBuscado), equalTo(false))
        );
    }
}