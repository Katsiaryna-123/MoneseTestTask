package androidcore.elements;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class AssistantPageElements {
    protected AndroidDriver androidDriver;

    public AssistantPageElements(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public WebElement chooseAssistantHeader() {
        return androidDriver.findElement(AppiumBy.accessibilityId("Choose assistant"));
    }

    public WebElement maryImage() {
        return androidDriver.findElement(AppiumBy.accessibilityId("Mary"));
    }

    public WebElement maxImage() {
        return androidDriver.findElement(AppiumBy.accessibilityId("Max"));
    }

    public WebElement noAssistantImage() {
        return androidDriver.findElement(AppiumBy.accessibilityId("No assistant"));
    }
}
