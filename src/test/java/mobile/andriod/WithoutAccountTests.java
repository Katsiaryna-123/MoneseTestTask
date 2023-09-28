package mobile.andriod;

import android.applications.TodoistApplication;
import helpers.owners.OwnerKatsia;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import parameterresolvers.TodoistApplicationParameterResolver;
import tags.AndroidTag;

@Feature("Assistant page")
@AndroidTag
@OwnerKatsia
class WithoutAccountTests {

    @Test
    @AllureId("3")
    @DisplayName("Check assistance page (positive test)")
    @ExtendWith(TodoistApplicationParameterResolver.class)
    public void shouldDisplayCorrectInformationWhenNavigatingToAssistantPage(TodoistApplication app) {
        app.assistantPage().clickContinueBtn();

        app.assistantPage()
                .assertions()
                .checkAssistantPage();
    }
}