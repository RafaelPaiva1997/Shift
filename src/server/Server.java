package server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Paivex on 2/17/2017.
 */
public class Server {
    private ServerSocket socket;
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public boolean start() {
        boolean flag = true;
        try {
            socket = new ServerSocket(port);
            while(flag) {
                Thread thread = new Thread(new Client_Handler(socket.accept()));
                thread.run();
            }

        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }
}
