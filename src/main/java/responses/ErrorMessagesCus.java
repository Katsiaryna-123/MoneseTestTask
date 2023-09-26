package responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(fluent = true)

public enum ErrorMessagesCus {

    TASK_NOT_FOUND("Task not found");

    @Getter
    private final String value;
}
