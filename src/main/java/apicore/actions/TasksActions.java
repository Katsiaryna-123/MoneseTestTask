package apicore.actions;

import apicore.connectors.Connector;
import apicore.pojo.CreateTaskRequest;
import apicore.requests.TodoistRequests;
import apicore.responses.CreateTaskResponse;
import io.qameta.allure.Step;
import io.restassured.common.mapper.TypeRef;

public class TasksActions {

    private final Connector connector;

    public TasksActions(Connector connector) {
        this.connector = connector;
    }

    @Step("Create task")
    public CreateTaskResponse createTask(CreateTaskRequest createTask) {
        return connector.send(TodoistRequests.createTask(createTask)
                        .build())
                .ifOk()
                .getDataResponse(new TypeRef<>() {
                });
    }

    @Step("Get task")
    public CreateTaskResponse getTask(String id) {
        return connector.send(TodoistRequests.getTask(id)
                        .build())
                .ifOk()
                .getDataResponse(new TypeRef<>() {
                });
    }
}