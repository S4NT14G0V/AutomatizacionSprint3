package org.calidadsoftware.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.calidadsoftware.api.AceptarSolicitud;
import org.calidadsoftware.api.EnviarSolicitud;
import org.calidadsoftware.api.LoginUsuario;
import org.calidadsoftware.api.RegistrarUsuario;
import org.calidadsoftware.interactions.ClickOn;
import org.calidadsoftware.interfaces.BottomNavbarPage;
import org.calidadsoftware.utils.WaitFor;

public class NavegarFriendsEliminar implements Task {

    public NavegarFriendsEliminar() {}

    public static NavegarFriendsEliminar go() {
        return Tasks.instrumented(NavegarFriendsEliminar.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String email = Faker.instance().internet().emailAddress();
        String username = Faker.instance().name().username();
        String fullname = Faker.instance().name().fullName();
        String password = "123456S$";
        String receptorId = "692cc2cf73672d6a26b57ae6";

        // Registrar usuario falso
        String token_sender = RegistrarUsuario.enBackend(email, fullname, username, password);

        // Enviar solicitud al usuario logueado
        String requestId = EnviarSolicitud.enviar(token_sender, receptorId);

        // Loguear como el usuario receptor para aceptar la solicitud
        String token_receptor = LoginUsuario.enBackend("santiago.tbolivar@udea.edu.co","123456S$");

        // Aceptar la solicitud de amistad
        AceptarSolicitud.enviar(token_receptor, requestId);

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
