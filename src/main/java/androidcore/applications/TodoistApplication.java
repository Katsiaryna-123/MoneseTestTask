package androidcore.applications;

import androidcore.pages.AssistantPage;
import androidcore.pages.StartPage;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TodoistApplication {

    AndroidDriver driver;
    AssistantPage assistantPage;
    StartPage startPage;

    @SneakyThrows
    public TodoistApplication(AndroidDriver driver) {
        this.driver = driver;
    }

    public AssistantPage getAssistantPage() {
        if (assistantPage == null) {
            assistantPage = new AssistantPage(driver);
        }
        return assistantPage;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage(driver);
        }
        return startPage;
    }

    public void close() {
        driver.quit();
    }
}
