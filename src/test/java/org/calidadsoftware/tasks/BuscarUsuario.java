package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interactions.EnterText;
import org.calidadsoftware.interfaces.FriendsPage;
import org.calidadsoftware.utils.WaitFor;

public class BuscarUsuario implements Task {

    private final String username;

    public BuscarUsuario(String username) {
        this.username = username;
    }

    public static BuscarUsuario conNombre(String username) {
        return Tasks.instrumented(BuscarUsuario.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.BTN_ADD_FRIEND_NAV),
                WaitFor.sleep(2),
                EnterText.valueInto(username, FriendsPage.USER_SEARCH_INPUT),
                WaitFor.sleep(2),
                ClickOn.target(FriendsPage.USER_SEARCH_RESULT),
                WaitFor.sleep(2)
        );
    }
}

