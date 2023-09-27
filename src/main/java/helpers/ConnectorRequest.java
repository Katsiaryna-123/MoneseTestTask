package helpers;

import java.util.Map;

public interface ConnectorRequest {
    String getBaseUri();

    Method getMethod();

    String getPath();

    Object getRequestBody();

    Map<String, ?> getPathParams();

    Map<String, ?> getQueryParams();

    Map<String, ?> getFormParams();

    Map<String, String> getHeaders();

    String getContentType();

    Map<String, ?> getCookies();

    String getBasePath();

}
