package helpers;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
    public <T> T getDataResponse(Class<T> clazz) {
        return response.as(clazz);
    }

    @Override
    public byte[] getDataResponse() {
        return response.asByteArray();
    }

    @Override
    public int getResponseCode() {
        return response.statusCode();
    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(response.getHeaders().iterator(), Spliterator.SORTED), false)
                .collect(Collectors.toMap(Header::getName, header -> List.of(header.getValue()), (h1, h2) ->
                        Stream.concat(h1.stream(), h2.stream())
                                .collect(Collectors.toList())));
    }

    public String getCookie(String key) {
        return response.getCookie(key);
    }

    public String getHeader(String key) {
        return response.getHeader(key);
    }
}
