package assessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class App {

    public static void main(String[] args) throws IOException {
        String dataFile = "./static/" + args[0];
        String templateFile = "./static/" + args[1];

        DataHandler dh = new DataHandler();
        TWriter tWriter = new TWriter();
        BufferedReader br = new BufferedReader(new FileReader(dataFile));

        String data = br.readLine(); // Removing header

        while (data != null) {
            data = br.readLine();
            Map<String, String> readData = dh.read(data);
            tWriter.write(readData, templateFile);
        }
        br.close();
    }
}
