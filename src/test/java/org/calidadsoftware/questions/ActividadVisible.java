package org.calidadsoftware.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.calidadsoftware.interfaces.ActivityPage;

public class ActividadVisible implements Question<Boolean> {

    private final Target target;

    public ActividadVisible(Target target) {
        this.target = target;
    }

    public static ActividadVisible mostrado() {
        return new ActividadVisible(ActivityPage.ACTIVITY_SCREEN);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return target.resolveFor(actor).isVisible();
        } catch (Exception e) {
            return false;
        }
    }
}

