package api;

import actions.TasksActions;
import assertions.TasksAssertions;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import helpers.CommonAssertions;
import helpers.Connector;
import parameterresolvers.ConnectorParameterResolver;
import requests.TodoistRequests;
import pojo.CreateTaskRequest;
import responses.CreateTaskResponse;

import static helpers.ErrorMessage.TASK_NOT_FOUND;

public class GetTaskTests {

    @Test
    @AllureId("1")
    @DisplayName("Get task (positive test)")
    @ExtendWith(ConnectorParameterResolver.class)
    void getTask(Connector connector) {
        TasksActions tasksActions = new TasksActions(connector);
        CreateTaskRequest taskData = CreateTaskRequest.builder().build();

        String taskId = tasksActions.createTask(taskData).getId();

        CreateTaskResponse createdTask = tasksActions.getTask(taskId);

        TasksAssertions.checkCreatedTaskData.accept(createdTask, new TasksAssertions.AssertionParams()
                .taskData(taskData));
    }

    @Test
    @AllureId("2")
    @DisplayName("Get non-existing task (negative test)")
    @ExtendWith(ConnectorParameterResolver.class)
    void getNonExistingTask(Connector connector) {
        CommonAssertions.checkNotFoundRequestBody(connector.send(TodoistRequests.getTask("any").build()),
                new CommonAssertions.Params().errorText(TASK_NOT_FOUND));
    }
}
