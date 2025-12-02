package org.calidadsoftware.interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target SAFE_AREA =
            Target.the("área segura de login")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"loginScreen_SafeAreaView\"]");

    public static final Target INPUT_EMAIL =
            Target.the("campo email")
                    .locatedBy("//android.widget.EditText[@resource-id=\"loginScreen_InputEmail\"]");

    public static final Target ERROR_EMAIL =
            Target.the("mensaje error email")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"loginScreen_ErrorEmail\"]");

    public static final Target INPUT_PASSWORD =
            Target.the("campo contraseña")
                    .locatedBy("//android.widget.EditText[@resource-id=\"loginScreen_InputPassword\"]");

    public static final Target ERROR_PASSWORD =
            Target.the("mensaje error contraseña")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"loginScreen_ErrorPassword\"]");

    public static final Target BTN_LOGIN =
            Target.the("botón login")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Login\"]");

    public static final Target BTN_GOOGLE =
            Target.the("botón login con Google")
                    .locatedBy("//android.widget.TextView[@resource-id=\"loginScreen_ButtonGoogleText\"]");

    public static final Target BTN_SIGNUP =
            Target.the("botón ir a registro")
                    .locatedBy("//android.widget.TextView[@resource-id=\"loginScreen_SignupLink\"]");
}