package androidcore.pages;

import androidcore.elements.StartPageElements;
import apicore.Waiter;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

import static apicore.Waiter.Preset.WAIT_FOR_ELEMENT;

public class StartPage {
    private final StartPageElements elements;

    public StartPage(AndroidDriver driver) {
        elements = new StartPageElements(driver);
    }

    @Step("Click continue button")
    public void clickContinueBtn() {
        new Waiter(WAIT_FOR_ELEMENT)
                .tryUntil(() -> elements
                        .continueWithoutAccountBtn()
                        .isDisplayed());

        elements.continueWithoutAccountBtn().click();
    }
}
