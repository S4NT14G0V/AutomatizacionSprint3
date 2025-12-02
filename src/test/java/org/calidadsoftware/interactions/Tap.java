package org.calidadsoftware.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class Tap implements Interaction {

    private final Target target;

    private Tap(Target target) {
        this.target = target;
    }

    public static Tap on(Target target) {
        return new Tap(target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        target.resolveFor(actor).click();
    }
}
