package helpers;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
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
    private final Map<String, ?> queryParams;
    @Getter
    private final Map<String, ?> formParams;
    @Getter
    private final Map<String, String> headers;
    @Getter
    private final String contentType;
    @Getter
    private final Map<String, String> cookies;
    @Getter
    Object requestBody;
    @Getter
    private final String basePath;


    Request(String baseUri,
            String path,
            Method method,
            Map<String, ?> pathParams,
            Map<String, ?> queryParams,
            Map<String, ?> formParams,
            Map<String, String> headers,
            String contentType,
            Map<String, String> cookies,
            Object requestBody,
            String basePath) {
        this.baseUri = baseUri;
        this.path = path;
        this.method = method;
        this.pathParams = pathParams;
        this.queryParams = queryParams;
        this.formParams = formParams;
        this.headers = headers;
        this.contentType = contentType;
        this.cookies = cookies;
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
        private Map<String, ?> queryParams;
        private Map<String, ?> formParams;
        private Map<String, String> headers = new HashMap<>();
        private String contentType = "application/json";
        private Map<String, String> cookies = new HashMap<>();
        private Object requestBody;
        private String basePath;

        RequestBuilder() {
        }

//        public RequestBuilder(Map<String, String> headers) {
//            this.headers = headers;
//        }

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

        public RequestBuilder queryParams(Map<String, ?> queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        public RequestBuilder formParams(Map<String, ?> formParams) {
            this.formParams = formParams;
            return this;
        }

        public RequestBuilder headers(Map<String, String> headers) {
            this.headers.putAll(headers);
            return this;
        }
        //TODO: что-то надо сделать с этим да и вообще разобраться что это за класс и как его сократить

        public RequestBuilder authorized() {
            this.headers.put("Bearer Token", "7a223d0685fe8c6e10eb51e2f0889d8ab084c744");
            return this;
        }

        public RequestBuilder authorizedWithoutRole() {
            this.headers.put("X-Auth-Token", "not valid token");
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
            return new Request(baseUri, path, method, pathParams, queryParams, formParams, headers, contentType, cookies, requestBody, basePath);
        }
    }
}
