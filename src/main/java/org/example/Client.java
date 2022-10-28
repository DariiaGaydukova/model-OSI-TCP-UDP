package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8082;

        try (Socket clientSocket = new Socket(host, port)) {

            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);) {

                String answerServer = in.readLine();

                System.out.println(answerServer);


                Scanner scan = new Scanner(System.in);
                String clientCity = scan.nextLine();

                out.println(clientCity);

                answerServer = in.readLine();

                if (answerServer.equals("OK")) {
                    System.out.println("Ваш ход засчитан");
                }
                if (answerServer.equals("NOT OK")) {
                    System.out.println("Ваш ход не засчитан, попытайтесь снова");
                }


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
