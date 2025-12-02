package org.calidadsoftware.interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ProfilePage {

    public static final Target BTN_EDITAR =
            Target.the("botón editar perfil")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Edit profile\"]");

    public static final Target INPUT_USERNAME =
            Target.the("campo username")
                    .locatedBy("//android.widget.EditText[@resource-id=\"profileEdit_InputUsername\"]");

    public static final Target INPUT_FULLNAME =
            Target.the("campo nombre completo")
                    .locatedBy("//android.widget.EditText[@resource-id=\"profileEdit_InputFullName\"]");

    public static final Target BTN_GUARDAR =
            Target.the("botón guardar")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Save Changes\"]");

    public static final Target MENSAJE_RESPUESTA =
            Target.the("toast de mensaje")
                    .locatedBy("//*[@content-desc='resultMessage']");

    public static final Target NOMBRE_USUARIO =
            Target.the("nombre de usuario en perfil")
                    .locatedBy("//android.widget.TextView[@resource-id=\"profileScreen_Username\"]");

    public static final Target NOMBRE_COMPLETO =
            Target.the("nombre completo en perfil")
                    .locatedBy("//android.widget.TextView[@resource-id=\"profileScreen_FullName\"]");

    public static final Target PROFILE_EDIT_SCREEN =
            Target.the("pantalla de edición de perfil")
                    .locatedBy("//android.widget.ScrollView[@resource-id=\"profileScreen_ScrollView\"]");

    public static final Target ERROR_MESSAGE_FULLNAME =
            Target.the("mensaje de error de fullname")
                    .locatedBy("//android.widget.TextView[@resource-id=\"profileEdit_ErrorFullName\"]");

    public static final Target ERROR_MESSAGE_USERNAME =
            Target.the("mensaje de error de username")
                    .locatedBy("//android.widget.TextView[@resource-id=\"profileEdit_ErrorUsername\"]");

    public static final Target ERROR_SAME_USERNAME =
            Target.the("mensaje de error de username igual al anterior")
                    .locatedBy("//android.widget.TextView[@resource-id=\"profileEdit_ErrorUsername\"]");
}
