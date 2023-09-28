package assertions;


import lombok.Data;
import lombok.experimental.Accessors;
import org.assertj.core.api.SoftAssertions;
import pojo.CreateTaskRequest;
import responses.CreateTaskResponse;

import java.util.function.BiConsumer;

import static io.qameta.allure.Allure.step;

public class TasksAssertions {

    public static BiConsumer<CreateTaskResponse, AssertionParams> checkCreatedTaskData =
            (response, params) -> step("Check created task data", () -> {

                SoftAssertions softly = new SoftAssertions();
                softly.assertThat(response.content).as("Actual content").isEqualTo(params.taskData.getContent());
                softly.assertThat(response.priority).as("Actual priority").isEqualTo(params.taskData.getPriority());
                softly.assertThat(response.due.string).as("Actual string").isEqualTo(params.taskData.getDue_string());
                softly.assertThat(response.due.lang).as("Actual lang").isEqualTo(params.taskData.getDue_lang());

                softly.assertAll();
            });

    @Data
    @Accessors(fluent = true)
    public static class AssertionParams {
        private CreateTaskRequest taskData;
    }
}
