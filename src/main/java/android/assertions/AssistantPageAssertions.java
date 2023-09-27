package android.assertions;

import helpers.Waiter;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import android.elements.AssistantPageElements;

public class AssistantPageAssertions {

    AssistantPageElements elements;
    AndroidDriver driver;

    public AssistantPageAssertions(AssistantPageElements elements, AndroidDriver driver) {
        this.elements = elements;
        this.driver = driver;
    }

    @Step("Check assistant page")
    public AssistantPageAssertions checkAssistantPage() {
        new Waiter(Waiter.Preset.WAIT_FOR_ELEMENT).alias("Waiting element to be visible").until(() -> elements.chooseAssistantHeader().isDisplayed());

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(elements.maryImage().isDisplayed()).as("Mary image present").isTrue();
        softly.assertThat(elements.maxImage().isDisplayed()).as("Max image present").isTrue();
        softly.assertThat(elements.noAssistantImage().isDisplayed()).as("No assistant image present").isTrue();

        softly.assertAll();

        return this;
    }
}
