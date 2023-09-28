package mobile.andriod;

import androidcore.applications.TodoistApplication;
import tags.owners.OwnerKatsia;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import androidcore.TodoistApplicationParameterResolver;
import tags.AndroidTag;

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