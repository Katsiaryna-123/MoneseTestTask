package actions;

import helpers.Connector;
import io.qameta.allure.Step;
import io.restassured.common.mapper.TypeRef;
import pojo.CreateTaskRequest;
import requests.TodoistRequests;
import responses.CreateTaskResponse;

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