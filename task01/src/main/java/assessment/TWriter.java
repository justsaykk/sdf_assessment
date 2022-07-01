package assessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TWriter {

    public void write(Map<String, String> readData, String templateFile)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(templateFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] splitLine = line.split("__");
            List<String> splitList = new ArrayList<>();
            Collections.addAll(splitList, splitLine);

            for (int i = 0; i < splitList.size(); i++) {
                for (int j = 0; j < readData.size(); j++) {
                    if (readData.containsKey(splitList.get(i))) {
                        splitList.set(i, readData.get(splitList.get(i)));
                    }
                }
            }
            String newLine = splitList.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace("\\n", "\n")
                    .replace(", ", "");
            System.out.println(newLine);
        }
        br.close();
    }
}
