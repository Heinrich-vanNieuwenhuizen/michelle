package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import za.co.task.javaprograms.P3Server;

public class PlayerModel implements Runnable {
    static int descriptor = 1;
    int _descriptor;
    volatile boolean shutdown = false;
    String group;
    Socket socket;
    public PlayerModel(Socket fromServer) {
        _descriptor = descriptor++;
        socket = fromServer;
        System.out.println("Just connected to " + socket.getRemoteSocketAddress());
        this.run();
    }


    @Override
    public void run() {
        InputStreamReader in = null;
        try {

            in = new InputStreamReader(socket.getInputStream());
            BufferedReader bf = new BufferedReader(in);
            while(!shutdown) {
                int firstChar = socket.getInputStream().read();
                if(firstChar == -1) {
                    System.out.println(_descriptor + " Disconnected");
                    shutdown = true;
                    P3Server.players.removeIf(p -> (p._descriptor == _descriptor));
                }
                if(!shutdown) {
                    System.out.println(_descriptor + " : " + (char) firstChar + bf.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
