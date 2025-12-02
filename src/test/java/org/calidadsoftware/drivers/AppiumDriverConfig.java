package org.calidadsoftware.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import net.serenitybdd.core.webdriver.driverproviders.DriverProvider;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.time.Duration;
import java.nio.file.Paths;

public class AppiumDriverConfig implements DriverProvider {

    @Override
    public WebDriver newInstance(String options, EnvironmentVariables environmentVariables) {
        try {
            UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();

            uiAutomator2Options.setDeviceName("emulator-5554");
            uiAutomator2Options.setAutomationName("UiAutomator2");
            uiAutomator2Options.setPlatformName("Android");
            uiAutomator2Options.setAppPackage("com.anonymous.FRONTEND");
            uiAutomator2Options.setAppActivity(".MainActivity");
            uiAutomator2Options.setNoReset(true);
            uiAutomator2Options.setApp(Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "apps", "app.apk").toString());
            uiAutomator2Options.setAutoGrantPermissions(true);
            uiAutomator2Options.setGpsEnabled(true);
            // evitar que sesiones se cierren por inactividad rápidamente
            uiAutomator2Options.setNewCommandTimeout(Duration.ofSeconds(300));
            // aumentar timeouts y opciones para evitar crashes intermitentes del servidor UiAutomator2
            uiAutomator2Options.setCapability("adbExecTimeout", 600000); // ms
            uiAutomator2Options.setCapability("uiautomator2ServerInstallTimeout", 600000);
            uiAutomator2Options.setCapability("clearSystemFiles", true);
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), uiAutomator2Options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            return driver;

        } catch (Exception e) {
            throw new RuntimeException("Error inicializando driver Appium", e);
        }
    }
}
