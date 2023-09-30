package androidcore.pages;

import androidcore.assertions.AssistantPageAssertions;
import androidcore.elements.AssistantPageElements;
import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import lombok.experimental.Accessors;

public class AssistantPage {

    @Getter
    @Accessors(fluent = true)
    private final AssistantPageAssertions assertions;

    public AssistantPage(AndroidDriver driver) {
        AssistantPageElements elements = new AssistantPageElements(driver);
        assertions = new AssistantPageAssertions(elements, driver);
    }
}
