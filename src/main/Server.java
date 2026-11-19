package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Server {


    public static void main(String[] args) {

        try (
                ServerSocket serverSocket = new ServerSocket(5000)
        ) {
            System.out.println("Server is running");
            System.out.println("Waiting for client");


            {
                List<String> matchResults = new ArrayList<>();

                while (true) {
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String data;

                    while ((data = in.readLine()) != null) {
                        matchResults.add(data);

                        String[] matchData = data.split(";");

                        String playerName = matchData[0];
                        String playerCharacter = matchData[1];
                        String computerCharacter = matchData[2];
                        String result = matchData[3];

                        System.out.println("Spelare namn: " + matchData[0]);
                        System.out.println("Spelare karaktär: " + matchData[1]);
                        System.out.println("Dator karaktär: " + matchData[2]);
                        System.out.println("Vinnare: " + matchData[3]);

                    }


                }




            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}



