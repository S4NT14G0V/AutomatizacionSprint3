package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.interfaces.ActivityPage;
import org.calidadsoftware.interactions.ClickOn;

public class SeleccionarActividad implements Task {

    private final String actividad;

    public SeleccionarActividad(String actividad) {
        this.actividad = actividad;
    }

    public static SeleccionarActividad desdeLista(String actividad) {
        return Tasks.instrumented(SeleccionarActividad.class, actividad);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (actividad.toLowerCase()) {
            case "run":
                actor.attemptsTo(ClickOn.target(ActivityPage.BTN_RUN_ACTIVITY));
                break;
            case "walk":
                actor.attemptsTo(ClickOn.target(ActivityPage.BTN_WALK_ACTIVITY));
                break;
            case "cyclism":
                actor.attemptsTo(ClickOn.target(ActivityPage.BTN_CYCLISM_ACTIVITY));
                break;
            case "hiking":
                actor.attemptsTo(ClickOn.target(ActivityPage.BTN_HIKING_ACTIVITY));
                break;
            default:
                // si no se reconoce, intentar por run como fallback
                actor.attemptsTo(ClickOn.target(ActivityPage.BTN_RUN_ACTIVITY));
                break;
        }
    }
}

