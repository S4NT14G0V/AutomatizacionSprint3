package org.calidadsoftware.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.calidadsoftware.interfaces.ProfilePage;

public class PageProfileVisible implements Question<Boolean> {

    public static PageProfileVisible mostrado() {
        return new PageProfileVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return ProfilePage.PROFILE_EDIT_SCREEN.resolveFor(actor).isVisible();
    }
}
