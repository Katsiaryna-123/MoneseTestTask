package mobile.andriod;

import androidcore.TodoistApplicationParameterResolver;
import androidcore.applications.TodoistApplication;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tags.AndroidTag;
import tags.owners.OwnerKatsia;

@Feature("Assistant page")
@AndroidTag
@OwnerKatsia
class AssistantPageTests {

    @Test
    @AllureId("3")
    @DisplayName("Check assistance page (positive test)")
    @ExtendWith(TodoistApplicationParameterResolver.class)
    public void shouldDisplayCorrectInformationWhenNavigatingToAssistantPage(TodoistApplication app) {
        app.getStartPage()
                .clickContinueBtn();

        app.getAssistantPage()
                .assertions()
                .checkAssistantPage();
    }
}