package pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTaskRequest {
    @Builder.Default
    public String content = "Buy Milk";
    @Builder.Default
    public String due_string = "tomorrow at 12:00";
    @Builder.Default
    public String due_lang = "en";
    @Builder.Default
    public int priority = 4;
}
