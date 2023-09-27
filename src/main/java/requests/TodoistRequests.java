package requests;

import helpers.Method;
import helpers.Request;
import pojo.CreateTaskRequest;

import java.util.Map;

public class TodoistRequests {
    private static final String BASE_PATH = "v2";

    public static Request.RequestBuilder getTask(String id) {
        return Request
                .baseServiceBuilder()
                .basePath(BASE_PATH)
                .path("tasks/{id}")
                .pathParams(Map.of("id", id))
                .method(Method.GET);
    }

    public static Request.RequestBuilder createTask(CreateTaskRequest createTask) {
        return Request
                .baseServiceBuilder()
                .basePath(BASE_PATH)
                .requestBody(createTask)
                .path("tasks")
                .method(Method.POST);
    }
}
