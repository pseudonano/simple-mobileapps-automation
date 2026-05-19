package tegpamsqa;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import tegpamsqa.config.*;

public class AppiumBasics {
    @Test
    public void AppiumTest() throws MalformedURLException {
        ConfigLoader loader = new ConfigLoader();
        Properties applicationProp = loader.loadProperties("application.properties");
        /* invoke appium service programmatically
         for cross-system you need to adjust filepath, server and port*/
        AppiumDriverLocalService service = new AppiumServiceBuilder().usingDriverExecutable(new File("/opt/homebrew/bin/node")).withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        // setting up device
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 9a API 36.0");
        options.setApp(applicationProp.getProperty("APP_PATH"));
        // setting up driver
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
        System.out.println("Application opened!");

        // close driver & appium service
        driver.quit();
        service.close();

    }

}
