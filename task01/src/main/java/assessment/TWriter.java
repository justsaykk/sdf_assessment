package assessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class TWriter {

    public void write(Map<String, String> readData, String templateFile)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(templateFile));
        System.out.println(readData);
        /*
         * Output: {address=221b Baker St\nLondon, first_name=Sherlock, years=22}
         */
        // String line;
        // while ((line = br.readLine()) != null) {
        //     String newLine = "";
        //     if (line.contains("__address__")) {
        //         newLine = line.replace("__address__", readData.get("address"));
        //         String newLine2 = newLine.replace("\\n", "\n");
        //         String newLine3 = newLine2.replace("\\n", "\n");
        //         System.out.println(newLine3);
        //     } else if (line.contains("__first_name__")) {
        //         newLine = line.replace("__first_name__", readData.get("first_name"));
        //         System.out.println(newLine);
        //     } else if (line.contains("__years__")) {
        //         newLine = line.replace("__years__", readData.get("years"));
        //         System.out.println(newLine);
        //     }
        // }
        br.close();
    }
}
