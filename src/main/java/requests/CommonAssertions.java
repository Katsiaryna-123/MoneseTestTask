package requests;

import lombok.Data;
import lombok.experimental.Accessors;
import org.assertj.core.api.AbstractAssert;
import responses.ErrorMessagesCus;

import java.util.function.BiFunction;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonAssertions<R, T> {

    public static void checkNotFoundRequestBody(ConnectorResponse response, Params params) {
        //TODO: hernya kakaya-to
        assertThat(new String(response.getDataResponse())).as("Actual error").isEqualTo(params.errorText().value());
    }

    @Data
    @Accessors(fluent = true)
    public static class Params {
        private ErrorMessagesCus errorText;
    }
}
