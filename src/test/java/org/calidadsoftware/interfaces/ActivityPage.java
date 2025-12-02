package org.calidadsoftware.interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ActivityPage {

    public static final Target BTN_RUN_ACTIVITY =
            Target.the("botón para iniciar una actividad de correr")
                    .locatedBy("//android.view.ViewGroup[@content-desc='🏃, Run']");

    public static final Target BTN_WALK_ACTIVITY =
            Target.the("botón para iniciar una actividad de caminar")
                    .locatedBy("//android.view.ViewGroup[@content-desc='🚶, Walk']");

    public static final Target BTN_CYCLISM_ACTIVITY =
            Target.the("botón para iniciar una actividad de ciclismo")
                    .locatedBy("//android.view.ViewGroup[@content-desc='🚴, Cyclism']");

    public static final Target BTN_HIKING_ACTIVITY =
            Target.the("botón para iniciar una actividad de escursionismo")
                    .locatedBy("//android.view.ViewGroup[@content-desc='🥾, Hiking']");

    public static final Target BTN_START_ACTIVITY =
            Target.the("botón para comenzar la actividad")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Start Activity\"]");

    public static final Target BTN_STOP_ACTIVITY =
            Target.the("botón para detener la actividad")
                    .locatedBy("//android.view.ViewGroup[@resource-id=\"activityTrackingScreen_ButtonFinish\"]");

    public static final Target ACTIVITY_SCREEN =
            Target.the("pantalla de actividad en curso")
                    .locatedBy("//android.view.ViewGroup[@resource-id=\"activityTrackingScreen_SafeAreaView\"]");

    public static final Target ACTIVITY_MAP =
            Target.the("mapa de la actividad en curso")
                    .locatedBy("//android.view.ViewGroup[@resource-id=\"activityTrackingScreen_MapContainer\"]");

    public static final Target BTN_PAUSE_ACTIVITY =
            Target.the("botón para pausar la actividad")
                    .locatedBy("//android.view.ViewGroup[@content-desc=\"Pause\"]");

    public static final Target ACTIVITY_LIST =
            Target.the("lista de actividades realizadas")
                    .locatedBy("//android.widget.ScrollView[@resource-id=\"activitySelectScreen_ActivityScrollView\"]");

    public static final Target ACTIVITY_LIST_ITEM =
            Target.the("elemento de la lista de actividades realizadas")
                    .locatedBy("(//android.view.ViewGroup[@resource-id=\"activityItemSelect_Container\"])[1]");

    public static final Target ACTIVITY_COMPLETED =
            Target.the("indicador de actividad completada")
                    .locatedBy("//android.widget.TextView[@resource-id=\"activityItemSelect_StatusText\" and @text=\"Completed\"]");
}
