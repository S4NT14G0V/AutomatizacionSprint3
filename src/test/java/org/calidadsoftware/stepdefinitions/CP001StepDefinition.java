package org.calidadsoftware.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.calidadsoftware.models.UserCredentials;
import org.calidadsoftware.models.UserProfileData;
import org.calidadsoftware.questions.ErrorProfileVisible;
import org.calidadsoftware.questions.NombreMostrado;
import org.calidadsoftware.questions.PageProfileVisible;
import org.calidadsoftware.tasks.EditarPerfil;
import org.calidadsoftware.tasks.IniciarSesion;
import org.calidadsoftware.tasks.NavegarProfile;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CP001StepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("el usuario ha iniciado sesión")
    public void usuarioLogueado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesion.conCredenciales(new UserCredentials("santiago.tbolivar@udea.edu.co", "123456S$"))
        );
    }

    @Given("está en la pantalla de edición de perfil")
    public void enPantallaPerfil() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavegarProfile.go()
        );
    }

    @When("modifica su nombre de usuario a {string} y su nombre completo a {string}")
    public void modificarDatos(String username, String fullname) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EditarPerfil.conDatos(new UserProfileData(username, fullname))
        );
    }

    @Then("es redirigido a la pantalla de perfil")
    public void validarRedireccion() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(PageProfileVisible.mostrado(), equalTo(true))
        );
    }

    @Then("visualiza los datos actualizados correctamente")
    public void validarCambios() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        NombreMostrado.enPantalla(),
                        equalTo("@"+UserProfileData.getLastUsernameEdited())
                )
        );
    }

    @Then("se muestra el mensaje de error")
    public void validarMensajeError() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        ErrorProfileVisible.mostrado(),
                        equalTo(true)
                )
        );
    }
}
