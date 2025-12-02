package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interfaces.FriendsPage;
import org.calidadsoftware.utils.WaitFor;

public class RechazarSolicitud implements Task {

    public RechazarSolicitud() {}

    public static RechazarSolicitud deLaLista() {
        return Tasks.instrumented(RechazarSolicitud.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.BTN_REJECT_FRIEND),
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.BTN_ACCEPT_TOAST_OK),
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.BTN_ACCEPT_MESSAGE_TOAST_SUCCESS_OK),
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.USER_SEARCH_CLOSE),
                WaitFor.sleep(2)
        );
    }
}

