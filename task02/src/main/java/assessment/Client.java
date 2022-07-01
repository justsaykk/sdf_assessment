package assessment;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private InputStream in;
    private OutputStream out;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket sock = new Socket("task02.chuklee.com", 80);
        Client client = new Client();
        client.initStreams(sock);

    }

    private void initStreams(Socket sock) throws IOException {
        out = sock.getOutputStream();
        in = sock.getInputStream();
        oos = new ObjectOutputStream(out);
        ois = new ObjectInputStream(in);
    }
}
