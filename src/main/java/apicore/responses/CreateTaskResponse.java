package apicore.responses;

import lombok.Data;

import java.util.List;

@Data
public class CreateTaskResponse {
    public String id;
    public Object assigner_id;
    public Object assignee_id;
    public String project_id;
    public Object section_id;
    public Object parent_id;
    public int order;
    public String content;
    public String description;
    public boolean is_completed;
    public List<String> labels;
    public int priority;
    public int comment_count;
    public String creator_id;
    public String created_at;
    public Due due;
    public String url;
    public Object duration;
}
