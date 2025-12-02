package org.calidadsoftware.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;
import org.calidadsoftware.interfaces.FriendsPage;

public class UsuarioEnLista implements Question<Boolean> {

    private final String username;

    public UsuarioEnLista(String username) {
        this.username = username;
    }

    public static UsuarioEnLista conNombre(String username) {
        return new UsuarioEnLista(username);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            List<WebElementFacade> elementos = FriendsPage.FRIENDS_LIST_USERNAME.resolveAllFor(actor);
            for (WebElementFacade el : elementos) {
                if (el.getText() != null && el.getText().contains(username)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}

