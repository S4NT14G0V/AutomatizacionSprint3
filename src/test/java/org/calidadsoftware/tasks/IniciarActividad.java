package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interfaces.ActivityPage;
import org.calidadsoftware.utils.WaitFor;

public class IniciarActividad implements Task {

    public IniciarActividad() {}

    public static IniciarActividad start() {
        return Tasks.instrumented(IniciarActividad.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.sleep(1),
                ClickOn.target(ActivityPage.BTN_START_ACTIVITY),
                WaitFor.sleep(1)
        );
    }
}

