package responses;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Due {
    public String date;
    public String string;
    public String lang;
    public boolean is_recurring;
    public String datetime;
}
