package org.calidadsoftware.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.calidadsoftware.interfaces.ProfilePage;

import java.util.stream.Stream;

public class ErrorProfileVisible implements Question<Boolean> {

    public static ErrorProfileVisible mostrado() {
        return new ErrorProfileVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Stream.of(
                ProfilePage.ERROR_MESSAGE_FULLNAME,
                ProfilePage.ERROR_MESSAGE_USERNAME,
                ProfilePage.ERROR_SAME_USERNAME
        ).anyMatch(target ->
                target.resolveAllFor(actor).stream().anyMatch(element -> element.isVisible())
        );
    }
}
