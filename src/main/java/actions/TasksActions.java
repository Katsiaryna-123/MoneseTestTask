package actions;

import io.qameta.allure.Step;
import io.restassured.common.mapper.TypeRef;
import requests.Connector;
import requests.TodoistRequests;
import requests.pojo.CreateTask;
import responses.CreateTaskResponse;

public class TasksActions {

    private final Connector connector;
//    private final String token;


    public TasksActions(Connector connector) {
        //  this.token = "ac";
        this.connector = connector;
    }

    @Step("Create task")
    public CreateTaskResponse createTask(CreateTask createTask) {
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