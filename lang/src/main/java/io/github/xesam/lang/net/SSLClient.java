package io.github.xesam.lang.net;

import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by xe on 16-5-13.
 */
public class SSLClient {
    public static void main(String[] args) {
        SSLClient client = new SSLClient();
        client.start();
    }

    public void start() {
        System.out.println("SSLClientSocket	Started");
        try {
            SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            Socket socket = sf.createSocket("localhost", 8000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter	text:	");
                String inputLine = scanner.nextLine();
                if ("quit".equalsIgnoreCase(inputLine)) {
                    break;
                }
                out.println(inputLine);
                System.out.println("Server	response:	" +
                        br.readLine());
            }
            System.out.println("SSLServerSocket	Terminated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
