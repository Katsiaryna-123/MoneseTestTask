package apicore.connectors;

import apicore.Method;

import java.util.Map;

public interface ConnectorRequest {
    String getBaseUri();

    Method getMethod();

    String getPath();

    Object getRequestBody();

    Map<String, ?> getPathParams();

    String getContentType();

    String getBasePath();
}
