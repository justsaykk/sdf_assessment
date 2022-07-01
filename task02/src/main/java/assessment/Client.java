package assessment;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket sock = new Socket("task02.chuklee.com", 80);
        List<Integer> list = new ArrayList<>();

        // Getting Streams:
        OutputStream out = sock.getOutputStream();
        InputStream in = sock.getInputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        ObjectInputStream ois = new ObjectInputStream(in);

        // Read and isolate initial Request from server
        String res = ois.readUTF();
        String[] split = res.split(" ");
        String requestID = split[0];
        String[] numbers = split[1].split(",");

        for (String el : numbers) {
            list.add(Integer.parseInt(el));
        }

        // Passing stuff to calculator
        Calculator task = new Calculator();
        Float average = task.calculate(list);

        // Write back to server
        String name = "Woo Kai Kein";
        String email = "kaikein.woo@gmail.com";
        oos.writeUTF(requestID);
        oos.writeUTF(name);
        oos.writeUTF(email);
        oos.writeFloat(average);
        oos.flush();

        // Read response from server
        if (ois.readBoolean()) {
            System.out.println("SUCCESS");
            out.close();
            in.close();
        } else {
            System.out.println("FAILED: " + ois.readUTF());
            out.close();
            in.close();
        }
    }
}
