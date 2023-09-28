package apicore.assertions;

import apicore.connectors.ConnectorResponse;
import apicore.ErrorMessage;
import lombok.Data;
import lombok.experimental.Accessors;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonAssertions {

    public static void checkNotFoundRequestBody(ConnectorResponse response, Params params) {
        assertThat(response.getDataResponse()).as("Actual error").isEqualTo(params.errorText().value());
    }

    @Data
    @Accessors(fluent = true)
    public static class Params {
        private ErrorMessage errorText;
    }
}
