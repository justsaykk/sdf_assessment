package assessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class App {
    public static void main(String[] args) throws IOException {
        String dataFile = "./static/" + args[0];
        // String templateFile = args[1];

        DataHandler dh = new DataHandler();
        Reader r = new FileReader(dataFile);
        BufferedReader br = new BufferedReader(r);

        String data = br.readLine(); // Removing header

        while (data != null) {
            data = br.readLine();
            dh.read(data);
        }
    }
}
