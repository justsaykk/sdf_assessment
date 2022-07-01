package assessment;

public class DataHandler {

    public void read(String data) {
        if ((data == null) || (data.trim().length() <= 0))
            return;

        String[] fields = data.split(",");
        String first_name = removeQ(fields[0]);
        String address = removeQ(fields[2]);
        String years = removeQ(fields[3]);

        System.out.printf("FirstName: %s, address: %s, years: %s \n", first_name, address, years);
    }

    private String removeQ(String s) {
        return s.replaceAll("\"", "");
    }
}
