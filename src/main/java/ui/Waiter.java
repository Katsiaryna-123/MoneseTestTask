package ui;

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
    private Object[] aliasTemplateArgs;

    public Waiter(Preset preset) {
        this.preset = preset;
        this.alias = preset.getAlias();
    }

    public Waiter(Preset preset, String alias) {
        this.preset = preset;
        this.alias = alias;
    }

    public Waiter alias(String alias) {
        this.alias = alias;
        return this;
    }

    public Waiter aliasTemplateArgs(Object... aliasTemplateArgs) {
        this.aliasTemplateArgs = aliasTemplateArgs;
        return this;
    }

    @SneakyThrows
    private ConditionFactory unwrapPreset() {
        if (alias == null) {
            throw new AliasForWaiterIsNotSetException();
        }
        return preset
                .getValue()
                .alias(aliasTemplateArgs != null && aliasTemplateArgs.length > 0
                        ? String.format(alias, aliasTemplateArgs)
                        : alias);
    }

    public void until(Callable<Boolean> conditionEvaluator) {
        unwrapPreset().until(conditionEvaluator);
    }

    @AllArgsConstructor
    @Getter
    public enum Preset {

        WAIT_FOR_ELEMENT(await().pollInterval(Duration.ofSeconds(1)).atMost(Duration.ofSeconds(10)),
                "Waiting for element to be displayed");
        private final ConditionFactory value;
        private final String alias;
    }
}
