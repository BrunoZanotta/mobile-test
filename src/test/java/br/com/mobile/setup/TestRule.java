package br.com.mobile.setup;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestRule {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        String serverUrl = System.getProperty("appium.server.url",
                System.getenv().getOrDefault("APPIUM_SERVER_URL", "https://hub.browserstack.com/wd/hub"));

        String appUrl = System.getProperty("app.url", System.getenv("APP_URL"));
        String bsUser = System.getProperty("browserstack.username", System.getenv("BS_USERNAME"));
        String bsKey  = System.getProperty("browserstack.accesskey", System.getenv("BS_ACCESS_KEY"));

        if (appUrl == null || bsUser == null || bsKey == null) {
            throw new IllegalStateException("APP_URL / BS_USERNAME / BS_ACCESS_KEY não configurados.");
        }

        String deviceName = System.getProperty("deviceName",
                System.getenv().getOrDefault("BS_DEVICE", "Google Pixel 6"));
        String osVersion = System.getProperty("osVersion",
                System.getenv().getOrDefault("BS_OS_VERSION", "12.0"));

        String project = System.getProperty("bs.project",
                System.getenv().getOrDefault("BS_PROJECT", "mobile-test"));
        String build = System.getProperty("bs.build",
                System.getenv().getOrDefault("BS_BUILD", "local-build"));

        Map<String, Object> bstack = new HashMap<>();
        bstack.put("userName", bsUser);
        bstack.put("accessKey", bsKey);
        bstack.put("deviceName", deviceName);
        bstack.put("osVersion", osVersion);
        bstack.put("projectName", project);
        bstack.put("buildName", build);
        bstack.put("sessionName", "CI run");
        bstack.put("realMobile", true);

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .amend("appium:app", appUrl)
                .amend("bstack:options", bstack)
                .setAppPackage("com.saucelabs.mydemoapp.rn")
                .setAppActivity(".MainActivity")
                .setAutoGrantPermissions(true);

        URL appiumServerUrl = new URL(serverUrl);

        driver = new AndroidDriver(appiumServerUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}