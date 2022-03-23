package thread;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket client;
    private String wRoot;

    public Socket getClient() {
        return client;
    }

    public ClientThread(Socket client, String wRoot){
        this.client = client;
        this.wRoot = wRoot;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    @SuppressWarnings("DuplicatedCode")
    @Override
    public void run() {

        try {
            // Obtain BufferReader and BufferWriter
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            // Read the msg from client
            String msg = br.readLine();
            String urn = msg.split(" ")[1];
            String urnWithoutSlash = urn.substring(1);

            debugKu(urnWithoutSlash);

            String fileContent = "";
            String statusCode;
            try {
                FileInputStream fipt = new FileInputStream(this.wRoot + urnWithoutSlash);
                fileContent = new String(fipt.readAllBytes());
                statusCode = "200 OK";
            }
            catch (FileNotFoundException e){
                fileContent = "404 File Not Found";
                statusCode = "404 Not Found";

            }

            while( !msg.isEmpty() ){
                System.out.println(msg);
                msg = br .readLine();
            }
            debugKu("2");

            // Write the reply msg to server
            bw.write("HTTP/1.0 "+statusCode+"\r\nContent-Type: text/html\r\nContent-length: "+fileContent.length()+"\r\n\r\n"+fileContent);
            bw.flush();
            debugKu("3");

            // Close the connection
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void debugKu(String s){
        System.out.println(" ===== IamHere ["+ s +"] :) ===== ");
    }
}
