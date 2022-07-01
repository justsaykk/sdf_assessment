package assessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws IOException {
        String dataFile = "./static/" + args[0];
        String templateFile = "./static/" + args[1];

        DataHandler dh = new DataHandler();
        TWriter tWriter = new TWriter();
        BufferedReader br = new BufferedReader(new FileReader(dataFile));

        // Setting the header row
        String header = br.readLine();
        List<String> headerList = dh.toList(header);

        // Getting the data
        String data;
        while ((data = br.readLine()) != null) {
            List<String> dataList = dh.toList(data);
            Map<String, String> mapData = dh.read(headerList, dataList);
            tWriter.write(mapData, templateFile);
        }
        br.close();
    }
}
