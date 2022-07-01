package assessment;

import java.util.HashMap;
import java.util.Map;

public class DataHandler {
    Map<String, String> dataRow = new HashMap<>();

    public Map<String, String> read(String data) {
        if ((data == null) || (data.trim().length() <= 0))
            return dataRow;

        String[] fields = data.split(",");

        dataRow.put("first_name", removeQ(fields[0]));
        dataRow.put("address", removeQ(fields[2]));
        dataRow.put("years", removeQ(fields[3]));

        return dataRow;
    }

    private String removeQ(String s) {
        return s.replaceAll("\"", "");
    }
}
