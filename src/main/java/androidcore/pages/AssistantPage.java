package androidcore.pages;

import androidcore.assertions.AssistantPageAssertions;
import androidcore.elements.AssistantPageElements;
import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import lombok.experimental.Accessors;

public class AssistantPage {

    private final AndroidDriver driver;
    private final AssistantPageElements elements;

    @Getter
    @Accessors(fluent = true)
    private final AssistantPageAssertions assertions;

    public AssistantPage(AndroidDriver driver) {
        this.driver = driver;
        elements = new AssistantPageElements(driver);
        assertions = new AssistantPageAssertions(elements, driver);
    }
}
