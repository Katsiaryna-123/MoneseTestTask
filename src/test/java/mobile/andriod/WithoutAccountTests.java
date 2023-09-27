package mobile.andriod;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import android.applications.TodoistApplication;
import parameterresolvers.TodoistApplicationParameterResolver;


public class WithoutAccountTests {

    @Test
    @AllureId("3")
    @DisplayName("Check assistance page (positive test)")
    @ExtendWith(TodoistApplicationParameterResolver.class)
    public void assistancePageTest(TodoistApplication app) {
        app.assistantPage().clickContinueBtn();

        app.assistantPage()
                .assertions()
                .checkAssistantPage();
    }
}