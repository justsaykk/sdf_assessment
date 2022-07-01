package assessment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandler {

    public Map<String, String> read(List<String> header, List<String> data) {
        Map<String, String> dataRow = new HashMap<>();
        for (int i = 0; i < header.size(); i++) {
            dataRow.put(header.get(i), data.get(i));
        }
        return dataRow;
    }

    public List<String> toList(String string) {
        List<String> list = new ArrayList<>();
        String[] stringArr = string.split(",");
        for (String el : stringArr) {
            list.add(removeQ(el));
        }
        return list;
    }

    private String removeQ(String s) {
        return s.replaceAll("\"", "");
    }
}
