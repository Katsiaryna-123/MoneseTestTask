package helpers;

import lombok.Data;
import lombok.experimental.Accessors;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonAssertions<R, T> {

    public static void checkNotFoundRequestBody(ConnectorResponse response, Params params) {
//TODO: hernya kakaya-to
        assertThat(new String(response.getDataResponse())).as("Actual error").isEqualTo(params.errorText().value());
    }

    @Data
    @Accessors(fluent = true)
    public static class Params {
        private ErrorMessage errorText;
    }
}
