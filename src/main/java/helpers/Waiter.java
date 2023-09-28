package helpers;

import exceptions.AliasForWaiterIsNotSetException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.awaitility.core.ConditionFactory;

import java.time.Duration;
import java.util.concurrent.Callable;

import static org.awaitility.Awaitility.await;

public class Waiter {

    private final Preset preset;
    private String alias;

    public Waiter(Preset preset) {
        this.preset = preset;
        this.alias = preset.getAlias();
    }

    public Waiter alias(String alias) {
        this.alias = alias;
        return this;
    }

    @SneakyThrows
    private ConditionFactory unwrapPreset() {
        if (alias == null) {
            throw new AliasForWaiterIsNotSetException();
        }
        return preset.getValue().alias(alias);
    }

    public void until(Callable<Boolean> conditionEvaluator) {
        unwrapPreset().until(conditionEvaluator);
    }

    @AllArgsConstructor
    @Getter
    public enum Preset {

        WAIT_FOR_ELEMENT(await().pollInterval(Duration.ofSeconds(1)).atMost(Duration.ofSeconds(15)),
                "Waiting for element to be displayed");
        private final ConditionFactory value;
        private final String alias;
    }
}
