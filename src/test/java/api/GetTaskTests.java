package api;

import apicore.ConnectorParameterResolver;
import apicore.actions.TasksActions;
import apicore.assertions.CommonAssertions;
import apicore.assertions.TasksAssertions;
import apicore.connectors.Connector;
import apicore.pojo.CreateTaskRequest;
import apicore.requests.TodoistRequests;
import apicore.responses.CreateTaskResponse;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tags.owners.OwnerKatsia;

import static apicore.ErrorMessage.TASK_NOT_FOUND;

@Feature("Get active task")
@Links({@Link(name = "Documentation", url = "https://developer.todoist.com/rest/v2/#get-an-active-task")})
@OwnerKatsia
@Owner("Katsiaryna Haspadaryk")
public class GetTaskTests {

    @Test
    @AllureId("1")
    @DisplayName("Get active task (positive test)")
    @ExtendWith(ConnectorParameterResolver.class)
    void shouldReturnActiveTaskWhenTaskExists(Connector connector) {
        TasksActions tasksActions = new TasksActions(connector);
        CreateTaskRequest taskData = CreateTaskRequest.builder().build();

        String taskId = tasksActions.createTask(taskData).getId();

        CreateTaskResponse createdTask = tasksActions.getTask(taskId);

        TasksAssertions.checkCreatedTaskData(createdTask, new TasksAssertions.AssertionParams()
                .taskData(taskData));
    }

    @Test
    @AllureId("2")
    @DisplayName("Get non-existing task (negative test)")
    @ExtendWith(ConnectorParameterResolver.class)
    void shouldReturnNullWhenGettingNonExistingTask(Connector connector) {
        CommonAssertions.checkNotFoundRequestBody(connector.send(TodoistRequests.getTask("any").build()),
                new CommonAssertions.Params().errorText(TASK_NOT_FOUND));
    }
}
