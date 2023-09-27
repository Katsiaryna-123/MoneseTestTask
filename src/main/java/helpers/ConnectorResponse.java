package helpers;


import io.restassured.common.mapper.TypeRef;

import java.util.List;
import java.util.Map;

public interface ConnectorResponse<R> {

    <T> T getDataResponse(TypeRef<T> typeRef);

    <T> T getDataResponse(Class<T> clazz);

    byte[] getDataResponse();

    default boolean isOk() {
        return getResponseCode() < 400;
    }

    int getResponseCode();

    default ConnectorResponse<R> ifOk() {
        if (isOk()) {
            return this;
        } else {
            throw new AssertionError(String.format("Response was not ok = %s", getResponseCode()));
        }
    }

    Map<String, List<String>> getHeaders();

    String getCookie(String key);

    String getHeader(String key);
}
