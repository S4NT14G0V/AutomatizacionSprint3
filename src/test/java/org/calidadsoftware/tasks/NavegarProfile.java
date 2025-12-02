package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interfaces.BottomNavbarPage;
import org.calidadsoftware.interfaces.ProfilePage;
import org.calidadsoftware.utils.WaitFor;

public class NavegarProfile implements Task {

    public NavegarProfile() {}

    public static NavegarProfile go() {
        return Tasks.instrumented(NavegarProfile.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.sleep(2),
                ClickOn.target(BottomNavbarPage.NAV_PROFILE),
                WaitFor.sleep(2),
                ClickOn.target(ProfilePage.BTN_EDITAR),
                WaitFor.sleep(2)
        );
    }
}
