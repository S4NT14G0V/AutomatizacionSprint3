package org.calidadsoftware.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class WriteOnMobile implements Interaction {

    private final WebElement element;
    private final String value;

    public WriteOnMobile(WebElement element, String value) {
        this.element = element;
        this.value = value;
    }

    public static WriteOnMobile theValue(WebElement element, String value) {
        return Tasks.instrumented(WriteOnMobile.class, element, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        element.clear();
        element.sendKeys(value);
    }
}
