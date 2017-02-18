package com.company;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    private static ServerSocket socket;
    private static int port = 40000;

    public static void main(String[] args) {
        boolean flag = true;
        try {

            socket = new ServerSocket(port);

            System.out.print("running on " + socket.getInetAddress());

            while(flag) new Thread(socket.accept());

        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        }
    }
}
