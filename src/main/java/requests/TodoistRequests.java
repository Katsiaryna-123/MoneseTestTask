package requests;

import requests.pojo.CreateTask;

import java.util.Map;

public class TodoistRequests {
    private static final String BASE_PATH = "tasks";

    public static Request.RequestBuilder getTask(String id) {
        return Request
                .baseServiceBuilder()
                //.basePath(BASE_PATH)
                .path("tasks/{id}")
                .pathParams(Map.of("id", id))
                .method(Method.GET);
    }

    public static Request.RequestBuilder createTask(CreateTask createTask) {
        return Request
                .baseServiceBuilder()
                .requestBody(createTask)
                .path("tasks")
                .method(Method.POST);
    }
}
