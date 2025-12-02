package org.calidadsoftware.interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BottomNavbarPage {

    public static final Target NAV_HOME =
            Target.the("botón home")
                    .locatedBy("//android.view.ViewGroup[@resource-id='bottomNavbar_Home']");

    public static final Target NAV_ACTIVITY =
            Target.the("botón actividad")
                    .locatedBy("//android.view.ViewGroup[@resource-id='bottomNavbar_Activity']");

    public static final Target NAV_FRIENDS =
            Target.the("botón amigos")
                    .locatedBy("//android.view.ViewGroup[@resource-id='bottomNavbar_Friends']");

    public static final Target NAV_LEADERBOARD =
            Target.the("botón leaderboard")
                    .locatedBy("//android.view.ViewGroup[@resource-id='bottomNavbar_Leaderboard']");

    public static final Target NAV_PROFILE =
            Target.the("botón perfil")
                    .locatedBy("//android.view.ViewGroup[@resource-id='bottomNavbar_Profile']");
}