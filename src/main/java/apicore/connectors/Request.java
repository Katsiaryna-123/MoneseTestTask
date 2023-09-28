package apicore.connectors;

import apicore.Method;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

public class Request implements ConnectorRequest {

    @Getter
    private final String baseUri;
    @Getter
    private final String path;
    @Getter
    private final Method method;
    @Getter
    private final Map<String, ?> pathParams;
    @Getter
    private final String contentType;
    @Getter
    Object requestBody;
    @Getter
    private final String basePath;


    Request(String baseUri,
            String path,
            Method method,
            Map<String, ?> pathParams,
            String contentType,
            Object requestBody,
            String basePath) {
        this.baseUri = baseUri;
        this.path = path;
        this.method = method;
        this.pathParams = pathParams;
        this.contentType = contentType;
        this.requestBody = requestBody;
        this.basePath = basePath;
    }

    public static RequestBuilder builder() {
        return new RequestBuilder();
    }

    public static RequestBuilder baseServiceBuilder() {
        return Request
                .builder()
                .baseUri("https://api.todoist.com/rest/");
    }

    @ToString
    public static class RequestBuilder {
        private String baseUri;
        private String path;
        private Method method;
        private Map<String, ?> pathParams;

        private String contentType = "application/json";

        private Object requestBody;
        private String basePath;

        RequestBuilder() {
        }


        public RequestBuilder baseUri(String baseUri) {
            this.baseUri = baseUri;
            return this;
        }

        public RequestBuilder path(String path) {
            this.path = path;
            return this;
        }

        public RequestBuilder method(Method method) {
            this.method = method;
            return this;
        }

        public RequestBuilder pathParams(Map<String, ?> pathParams) {
            this.pathParams = pathParams;
            return this;
        }

        public RequestBuilder requestBody(Object requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public RequestBuilder basePath(String basePath) {
            this.basePath = basePath;
            return this;
        }

        public ConnectorRequest build() {
            return new Request(baseUri, path, method, pathParams, contentType, requestBody, basePath);
        }
    }
}
