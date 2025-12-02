package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interfaces.FriendsPage;
import org.calidadsoftware.utils.WaitFor;
import org.checkerframework.checker.units.qual.C;

public class EliminarAmigo implements Task {

    public EliminarAmigo() {}

    public static EliminarAmigo deLaBusqueda() {
        return Tasks.instrumented(EliminarAmigo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.BTN_UNFRIEND),
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.BTN_REMOVE_FRIEND_TOAST_OK),
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.BTN_ACCEPT_MESSAGE_TOAST_SUCCESS_OK),
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.USER_SEARCH_CLOSE),
                WaitFor.sleep(2)
        );
    }
}

