package apicore.connectors;


import io.restassured.common.mapper.TypeRef;

public interface ConnectorResponse<R> {

    <T> T getDataResponse(TypeRef<T> typeRef);


    String getDataResponse();

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
}
