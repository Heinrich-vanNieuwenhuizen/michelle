package za.co.task.javaprograms;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import models.GameModel;
import models.PlayerModel;

public class P3Server extends Thread{
    private final ServerSocket serverSocket;
    static public List<PlayerModel> players = new ArrayList<>();
    static public List<GameModel> games = new ArrayList<>();
    public P3Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
//        serverSocket.setSoTimeout(10000);
    }
    class Thread1 implements Runnable {
        public void run() {
//            Socket socket;
//            try {
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
    public void run() {
        while(true) {
            try {
                System.out.println("Waiting for client on port " +
                        serverSocket.getLocalPort() + "...");
                Socket socket = serverSocket.accept();
                players.add(new PlayerModel(socket));




//                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//                out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress()
//                        + "\nGoodbye!");
//                socket.close();

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}