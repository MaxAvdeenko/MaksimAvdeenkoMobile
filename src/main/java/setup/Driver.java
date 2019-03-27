package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

import static io.appium.java_client.remote.MobileBrowserType.CHROME;
import static io.appium.java_client.remote.MobileBrowserType.SAFARI;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;


public class Driver extends TestProperties {

    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    private DesiredCapabilities capabilities;

    // Properties to be read
    protected static String AUT;
    protected static String SUT;
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String DEVICE_NAME;

    /**
     * Initialize driver with depending on platform and application
     *
     * @throws Exception
     */

    protected void prepareDriver() throws Exception {

        AUT = getProp("aut");
        String tSut = getProp("sut");
        SUT = tSut == null ? null : "https://" + tSut;
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        DEVICE_NAME = getProp("devicename");

        capabilities = new DesiredCapabilities();
        String browserName;

        //Setup browser depending on platform
        switch (TEST_PLATFORM) {
            case ANDROID:
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME); //default Android emulator
                browserName = CHROME;
                break;
            case IOS:
                browserName = SAFARI;
                break;
            default:
                throw new IllegalArgumentException();
        }

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        //Setup type of application: mobile, web or hybrid
        if (AUT != null && SUT == null) {
            //Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            //Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else throw new IllegalArgumentException();

        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }
        // Set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 10);
        }
    }

    protected AppiumDriver driver() throws Exception {
        return driverSingle;
    }

    protected WebDriverWait driverWait() throws Exception {
        return waitSingle;
    }
}
