package helpers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.qameta.allure.Allure.step;


public class RestAssuredConnector implements Connector {

    @Override
    public <T> ConnectorResponse<T> send(ConnectorRequest request) {

        //TODO: api key remove
        return step(String.format("Send %s Request to %s", request.getMethod(), request.getPath()), () -> {
            RequestSpecification spec = getRequestSpecification(request);
            Response response = RestAssured.given(spec)
                    .auth().oauth2("15c797109a58e37e107ddfe181e3720805d90179")
                    .request(request.getMethod().getValue(), request.getPath());
            return new RestAssuredResponse<>(response);
        });
    }

    private RequestSpecification getRequestSpecification(ConnectorRequest request) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(request.getBaseUri());

        builder.addFilters(List.of(new AllureRestAssured(), new RequestLoggingFilter(), new ResponseLoggingFilter()));

        if (request.getBasePath() != null) builder.setBasePath(request.getBasePath());
        if (request.getPathParams() != null) builder.addPathParams(request.getPathParams());
        if (request.getQueryParams() != null) builder.addQueryParams(request.getQueryParams());
        if (request.getFormParams() != null) builder.addFormParams(request.getFormParams());
        if (request.getHeaders() != null) builder.addHeaders(request.getHeaders());
        if (request.getContentType() != null) builder.setContentType(request.getContentType());
        if (request.getCookies() != null) builder.addCookies(request.getCookies());
        if (request.getRequestBody() != null) builder.setBody(request.getRequestBody());

        return builder.build();
    }
}
