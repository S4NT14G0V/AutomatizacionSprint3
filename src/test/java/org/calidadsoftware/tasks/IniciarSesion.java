package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interactions.WriteOnMobile;
import org.calidadsoftware.interfaces.LoginPage;
import org.calidadsoftware.models.UserCredentials;
import org.calidadsoftware.utils.WaitFor;

public class IniciarSesion implements Task{

    private final UserCredentials userCredentials;

    public IniciarSesion(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.sleep(2),
                WriteOnMobile.theValue(
                        LoginPage.INPUT_EMAIL.resolveFor(actor),
                        userCredentials.getEmail()
                ),
                WaitFor.sleep(2),
                WriteOnMobile.theValue(
                        LoginPage.INPUT_PASSWORD.resolveFor(actor),
                        userCredentials.getPassword()
                ),
                WaitFor.sleep(2),
                ClickOn.target(
                        LoginPage.BTN_LOGIN
                ),
                WaitFor.sleep(2)
        );
    }

    public static IniciarSesion conCredenciales(UserCredentials userCredentials) {
        return new IniciarSesion(userCredentials);
    }
}
