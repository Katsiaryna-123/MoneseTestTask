package mobile.andriod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Smoke {
    private static AndroidDriver driver;

    @BeforeSuite
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.VERSION, "8.1.0");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
        capabilities.setCapability(MobileCapabilityType.APP, "[PATH TO YOUR APP");
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @BeforeMethod
    public void setUp(){
        driver.resetApp();
    }

    @Test
    public void clickAppButtons(){
        driver.findElement(By.className("[CLASS NAME HERE]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("[ID OF ELEMENT HERE")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.closeApp();
    }
}
