package org.calidadsoftware.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.calidadsoftware.interfaces.ProfilePage;

public class NombreMostrado implements Question<String> {

    public static NombreMostrado enPantalla() {
        return new NombreMostrado();
    }

    @Override
    public String answeredBy(Actor actor) {
        return ProfilePage.NOMBRE_USUARIO.resolveFor(actor).getText();
    }
}
