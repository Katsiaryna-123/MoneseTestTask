package androidcore.pages;

import androidcore.elements.StartPageElements;
import apicore.Waiter;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

import static apicore.Waiter.Preset.WAIT_FOR_ELEMENT;

public class StartPage {

    private final AndroidDriver driver;
    private final StartPageElements elements;

    public StartPage(AndroidDriver driver) {
        this.driver = driver;
        elements = new StartPageElements(driver);
    }

    @Step("Click continue button")
    public StartPage clickContinueBtn() {

        //TODO: strange waiter
        new Waiter(WAIT_FOR_ELEMENT)
                .until(() -> elements
                        .continueWithoutAccountBtn()
                        .isDisplayed());

        elements.continueWithoutAccountBtn()
                .click();
        return this;
    }
}
