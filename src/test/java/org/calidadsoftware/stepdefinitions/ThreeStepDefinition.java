package org.calidadsoftware.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.calidadsoftware.tasks.IniciarActividad;
import org.calidadsoftware.tasks.NavegarActivity;
import org.calidadsoftware.tasks.SeleccionarActividad;
import org.calidadsoftware.questions.ActividadVisible;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class ThreeStepDefinition {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario-three");
    }

    @Given("está en la pantalla de actividades")
    public void enPantallaActividades() {
        theActorInTheSpotlight().attemptsTo(
                NavegarActivity.go()
        );
    }

    @When("inicia la actividad {string} desde la lista disponible")
    public void iniciaActividadDesdeLista(String actividad) {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarActividad.desdeLista(actividad),
                IniciarActividad.start()
        );
    }

    @Then("la pantalla de seguimiento se muestra correctamente")
    public void actividadVisible() {
        theActorInTheSpotlight().should(
                seeThat(ActividadVisible.mostrado(), equalTo(true))
        );
    }
}

