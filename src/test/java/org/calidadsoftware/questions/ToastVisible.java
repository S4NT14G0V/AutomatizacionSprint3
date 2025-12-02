package org.calidadsoftware.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ToastVisible implements Question<Boolean> {

    private final Target target;

    public ToastVisible(Target target) {
        this.target = target;
    }

    public static ToastVisible encontrado(Target target) {
        return new ToastVisible(target);
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

