package ui;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SeleniumLocator {

    By by;
    AppiumBy appiumBy;

    public SeleniumLocator(By by) {
        this.by = by;
    }

    public SeleniumLocator(AppiumBy appiumBy) {
        this.appiumBy = appiumBy;
    }
}
