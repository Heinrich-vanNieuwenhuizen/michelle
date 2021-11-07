package za.co.task.javaprograms;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] arg) {
        try {
            Thread t = new P3Server(5006);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
