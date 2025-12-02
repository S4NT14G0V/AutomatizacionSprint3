package org.calidadsoftware.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.calidadsoftware.interactions.WriteOnMobile;
import org.calidadsoftware.interfaces.ProfilePage;
import org.calidadsoftware.models.UserProfileData;
import org.calidadsoftware.utils.WaitFor;

public class EditarPerfil implements Task {

    private final UserProfileData data;

    public EditarPerfil(UserProfileData data) {
        this.data = data;
    }

    public static EditarPerfil conDatos(UserProfileData data) {
        return Tasks.instrumented(EditarPerfil.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.sleep(5),
                WriteOnMobile.theValue(
                        ProfilePage.INPUT_USERNAME.resolveFor(actor),
                        "" // Clear username field
                ),
                WaitFor.sleep(2),
                WriteOnMobile.theValue(
                        ProfilePage.INPUT_USERNAME.resolveFor(actor),
                        data.getUsername()
                ),
                WaitFor.sleep(2),
                WriteOnMobile.theValue(
                        ProfilePage.INPUT_FULLNAME.resolveFor(actor),
                        "" // Clear bio field
                ),
                WaitFor.sleep(2),
                WriteOnMobile.theValue(
                        ProfilePage.INPUT_FULLNAME.resolveFor(actor),
                        data.getFullname()
                ),
                WaitFor.sleep(2),
                Click.on(ProfilePage.BTN_GUARDAR)
        );
    }
}
