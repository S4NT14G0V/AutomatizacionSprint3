package org.calidadsoftware.interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FriendsPage {

    public static final Target SAFE_AREA =
            Target.the("área segura de login")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"loginScreen_SafeAreaView\"]");

    public static final Target BTN_ADD_FRIEND_NAV =
            Target.the("botón para navegar a agregar amigos")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Add Friend's\"]");

    public static final Target USER_SEARCH_INPUT =
            Target.the("campo de búsqueda de usuarios")
                    .locatedBy("//android.widget.EditText[@text=\"Search users globally...\"]");

    public static final Target USER_SEARCH_CLOSE =
            Target.the("botón para cerrar la búsqueda de usuarios")
                    // usar accessibility id cuando sea posible en Appium (acceso por content-desc)
                    .locatedBy("//android.view.ViewGroup[@content-desc='✕']");

    public static final Target USER_SEARCH_RESULT =
            Target.the("resultado de búsqueda de usuarios")
                    .locatedBy("//android.view.ViewGroup[@resource-id=\"searchResultItem_Container\"]");

    public static final Target USERNAME_IN_SEARCH_RESULT =
            Target.the("nombre de usuario en el resultado de búsqueda")
                    .locatedBy("//android.widget.TextView[@resource-id=\"searchResultItem_Username\"]");

    public static final Target BTN_ACCEPT_FRIEND =
            Target.the("botón agregar amigo")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Accept\"]");

    public static final Target BTN_REJECT_FRIEND =
            Target.the("botón rechazar amigo")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Reject\"]");

    public static final Target BTN_REMOVE_FRIEND =
            Target.the("botón eliminar amigo")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Reject\"]");

    public static final Target BTN_ADD_FRIEND =
            Target.the("botón agregar amigo desde perfil")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Add\"]");

    public static final Target ADD_MESSAGE_TOAST =
            Target.the("toast de mensaje al agregar amigo")
                    .locatedBy("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.anonymous.FRONTEND:id/parentPanel\"]");

    public static final Target BTN_TOAST_OK =
            Target.the("botón OK del toast")
                    .locatedBy("//android.widget.Button[@resource-id=\"android:id/button1\"]");

    public static final Target BTN_PENDING =
            Target.the("botón de solicitudes pendientes")
                    .locatedBy("//android.view.ViewGroup[@resource-id=\"searchResultItem_PendingButton\"]");

    public static final Target ACCEPT_MESAGE_TOAST =
            Target.the("toast de mensaje al aceptar solicitud de amigo")
                    .locatedBy("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.anonymous.FRONTEND:id/parentPanel\"]");

    public static final Target BTN_ACCEPT_TOAST_CANCEL =
            Target.the("botón CANCEL del toast de aceptar solicitud")
                    .locatedBy("//android.widget.Button[@resource-id=\"android:id/button2\"]");

    public static final Target BTN_ACCEPT_TOAST_OK =
            Target.the("botón OK del toast de aceptar solicitud")
                    .locatedBy("//android.widget.Button[@resource-id=\"android:id/button1\"]");

    public static final Target ACCEPT_MESSAGE_TOAST_SUCESS =
            Target.the("toast de mensaje de éxito al aceptar solicitud de amigo")
                    .locatedBy("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.anonymous.FRONTEND:id/parentPanel\"]");

    public static final Target BTN_ACCEPT_MESSAGE_TOAST_SUCCESS_OK =
            Target.the("botón OK del toast de éxito al aceptar solicitud")
                    .locatedBy("//android.widget.Button[@resource-id=\"android:id/button1\"]");

    public static final Target BTN_UNFRIEND =
            Target.the("botón para eliminar amigo desde busqueda")
                    .locatedBy("//android.view.ViewGroup[@resource-id=\"searchResultItem_ButtonUnfriend\"]");

    public static final Target REMOVE_FRIEND_TOAST =
            Target.the("toast de mensaje al eliminar amigo")
                    .locatedBy("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.anonymous.FRONTEND:id/parentPanel\"]");

    public static final Target BTN_REMOVE_FRIEND_TOAST_CANCEL =
            Target.the("botón CANCEL del toast de eliminar amigo")
                    .locatedBy("//android.widget.Button[@resource-id=\"android:id/button2\"]");

    public static final Target BTN_REMOVE_FRIEND_TOAST_OK =
            Target.the("botón OK del toast de eliminar amigo")
                    .locatedBy("//android.widget.Button[@resource-id=\"android:id/button1\"]");

    public static final Target REMOVE_FRIEND_TOAST_SUCCESS =
            Target.the("toast de mensaje de éxito al eliminar amigo")
                    .locatedBy("//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"com.anonymous.FRONTEND:id/parentPanel\"]");

    public static final Target BTN_REMOVE_FRIEND_TOAST_SUCCESS_OK =
            Target.the("botón OK del toast de éxito al eliminar amigo")
                    .locatedBy("//android.widget.Button[@resource-id=\"android:id/button1\"]");

    public static final Target FRIENDS_LIST =
            Target.the("lista de amigos")
                    .locatedBy("//android.widget.ScrollView[@resource-id=\"friendsScreen_ScrollView\"]");

    public static final Target FRIENDS_LIST_ITEM =
            Target.the("elemento de la lista de amigos")
                    .locatedBy("//android.widget.ScrollView[@resource-id=\"friendsScreen_FriendsScrollView\"]/android.view.ViewGroup");

    public static final Target FRIENDS_LIST_USERNAME =
            Target.the("nombre de usuario en la lista de amigos")
                    .locatedBy("//android.widget.TextView[@resource-id=\"friendItem_Username\"]");
}