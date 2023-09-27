package android.applications;

import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import android.pages.AssistantPage;

@Slf4j
public class TodoistApplication {

    AndroidDriver driver;

    @SneakyThrows
    public TodoistApplication(AndroidDriver driver) {
        this.driver = driver;
    }

    public AssistantPage assistantPage() {
        return new AssistantPage(driver);
    }
}