package androidcore.elements;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class StartPageElements {
    protected AndroidDriver androidDriver;

    public StartPageElements(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public WebElement continueWithoutAccountBtn() {
        return androidDriver.findElement(AppiumBy.accessibilityId("Continue without creating an account"));
    }
}
