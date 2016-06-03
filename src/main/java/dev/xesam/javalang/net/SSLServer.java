package dev.xesam.javalang.net;

import javax.net.ssl.SSLServerSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xe on 16-5-13.
 */
public class SSLServer {
    public static void main(String[] args) {
        SSLServer sslServer = new SSLServer();
        sslServer.start();
    }

    public void start() {
        try {
            SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            ServerSocket serverSocket = ssf.createServerSocket(8000);
            System.out.println("SSLServerSocket	Started");
            Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Client	socket	created");
            String line = null;
            while (((line = br.readLine()) != null)) {
                System.out.println(line);
                out.println(line);
            }
            br.close();
            System.out.println("SSLServerSocket	Terminated");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
