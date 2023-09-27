package android.pages;

import helpers.Waiter;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.experimental.Accessors;
import android.assertions.AssistantPageAssertions;
import android.elements.AssistantPageElements;

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

    @Step("Click continue button")
    public AssistantPage clickContinueBtn() {
        new Waiter(Waiter.Preset.WAIT_FOR_ELEMENT).alias("Waiting packages to be visible").until(() -> elements.continueWithoutAccountBtn().isDisplayed());

        elements.continueWithoutAccountBtn().click();
        return this;
    }
}
