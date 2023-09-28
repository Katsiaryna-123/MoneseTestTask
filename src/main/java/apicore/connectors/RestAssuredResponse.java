package apicore.connectors;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class RestAssuredResponse<R> implements ConnectorResponse<R> {

    Response response;

    public RestAssuredResponse(Response response) {
        this.response = response;
    }

    @Override
    public <T> T getDataResponse(TypeRef<T> typeRef) {
        return response.as(typeRef);
    }

    @Override
    public String getDataResponse() {
        return response.asString();
    }

    @Override
    public int getResponseCode() {
        return response.statusCode();
    }
}
