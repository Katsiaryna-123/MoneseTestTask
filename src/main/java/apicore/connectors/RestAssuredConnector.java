package apicore.connectors;

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

        return step(String.format("Send %s Request to %s", request.getMethod(), request.getPath()), () -> {
            RequestSpecification spec = getRequestSpecification(request);
            Response response = RestAssured.given(spec)
                    .auth()
                    //.oauth2("you can place token here for testing purposes")
                    .oauth2(System.getenv("TOKEN"))
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
        if (request.getContentType() != null) builder.setContentType(request.getContentType());
        if (request.getRequestBody() != null) builder.setBody(request.getRequestBody());

        return builder.build();
    }
}
