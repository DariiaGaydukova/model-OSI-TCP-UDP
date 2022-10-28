package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {
        int port = 8082;

        String actualCity = null;
        String newCity;


        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Игра Началась!");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {

                    if (actualCity == null) {

                        out.println("???");

                        newCity = in.readLine();
                        out.println("OK");
                        actualCity = newCity;
                        System.out.println("Текущее название города: " + actualCity);

                    } else {
                        out.println("Введите город,который начинается на последнюю букву: " + actualCity);
                        newCity = in.readLine();

                        char letterLast = actualCity.toLowerCase().charAt(actualCity.length() - 1);
                        char letterFirst = newCity.toLowerCase().charAt(0);

                        if (letterLast == letterFirst) {
                            System.out.println(letterLast + " d " + letterFirst);
                            out.println("OK");
                            newCity = actualCity;
                            System.out.println("Текущее название города: " + actualCity);
                        }
                        if (letterLast != letterFirst) {
                            out.println("NOT OK");
                            System.out.println(letterLast + letterFirst);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}