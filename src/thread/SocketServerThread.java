package thread;
/**
 * Week 6 : Wednesday, 23 Maret 2022
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerThread {
    public static void main(String[] args) throws IOException {

        // Untuk memesan addres tertentu saja yang boleh konek
        // Inet4Address addr = (Inet4Address) Inet4Address.getLoopbackAddress();

        String websiteRoot = "D:\\Coll\\6_6-ProgJar-C\\ProgjarFaderik\\src\\socketserver\\";
        ServerSocket server = new ServerSocket(80, 5);
        debugKu("0");

        while (true){

            Socket client = server.accept();
            debugKu("1");

            ClientThread clientThread = new ClientThread(client, websiteRoot);
            clientThread.start();

        }
//        server.close();
//        debugKu("4");

    }

    public static void debugKu(String s){
        System.out.println(" ===== IamHere ["+ s +"] :) ===== ");
    }
}
