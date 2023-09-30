package apicore.connectors;

import apicore.Method;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Request implements ConnectorRequest {
    private final String baseUri;
    private final String path;
    private final Method method;
    private final Map<String, ?> pathParams;
    private final String contentType;
    private final Object requestBody;
    private final String basePath;

    public static RequestBuilder baseServiceBuilder() {
        return Request
                .builder()
                .contentType("application/json")
                .baseUri("https://api.todoist.com/rest/");
    }
}
