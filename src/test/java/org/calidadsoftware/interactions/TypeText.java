package org.calidadsoftware.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class TypeText implements Interaction {

    private final Target target;
    private final String value;

    public TypeText(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    public static TypeText into(Target target, String value) {
        return new TypeText(target, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        target.resolveFor(actor).click();
        target.resolveFor(actor).sendKeys(value);
    }
}
