package org.calidadsoftware.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.api.EnviarSolicitud;
import org.calidadsoftware.api.RegistrarUsuario;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interfaces.BottomNavbarPage;
import org.calidadsoftware.utils.WaitFor;

public class NavegarFriendsAceptar implements Task {

    public NavegarFriendsAceptar() {}

    public static NavegarFriendsAceptar go() {
        return Tasks.instrumented(NavegarFriendsAceptar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String email = Faker.instance().internet().emailAddress();
        String username = Faker.instance().name().username();
        String fullname = Faker.instance().name().fullName();
        String password = "123456S$";
        String receptorId = "692cc2cf73672d6a26b57ae6";

        // Registrar usuario falso
        String token = RegistrarUsuario.enBackend(email, fullname, username, password);

        // Enviar solicitud al usuario logueado
        EnviarSolicitud.enviar(token, receptorId);

        // Guardar datos del usuario falso para usarlos después en el flujo
        actor.remember("fakeEmail", email);
        actor.remember("fakeUsername", username);

        actor.attemptsTo(
                WaitFor.sleep(2),
                ClickOn.target(BottomNavbarPage.NAV_FRIENDS),
                WaitFor.sleep(2)
        );
    }
}
