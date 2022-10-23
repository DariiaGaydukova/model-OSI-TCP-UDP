package org.example;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8081;

        try (Socket clientSocket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            {
                out.println("Hi! Dariia");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
