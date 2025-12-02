package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interfaces.BottomNavbarPage;
import org.calidadsoftware.utils.WaitFor;

public class NavegarActivity implements Task {

    public NavegarActivity() {}

    public static NavegarActivity go() {
        return Tasks.instrumented(NavegarActivity.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.sleep(2),
                ClickOn.target(BottomNavbarPage.NAV_ACTIVITY),
                WaitFor.sleep(2)
        );
    }
}

