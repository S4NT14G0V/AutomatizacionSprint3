package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interfaces.FriendsPage;
import org.calidadsoftware.utils.WaitFor;

public class AgregarAmigo implements Task {

    public AgregarAmigo() {}

    public static AgregarAmigo desdePerfil() {
        return Tasks.instrumented(AgregarAmigo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.BTN_ADD_FRIEND),
                WaitFor.sleep(2)
        );
    }
}

