package apicore.responses;

import lombok.Data;

@Data
public class Due {
    public String date;
    public String string;
    public String lang;
    public boolean is_recurring;
    public String datetime;
}
