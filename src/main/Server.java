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

        List<String> matchResults = new ArrayList<>();

        try (
                ServerSocket serverSocket = new ServerSocket(5000)
        ) {
            System.out.println("Server is running");
            System.out.println("Waiting for client");



            while (true) {

                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String data;

                while ((data = in.readLine()) != null) {

                    matchResults.add(data);
                    String[] matchData = data.split(";");

                    String playerCharacter = matchData[0];
                    String computerCharacter = matchData[1];
                    String result = matchData[2];

                    Files.write(
                            Path.of("results.txt"),
                            List.of(
                                    "Spelarens karaktär: " + playerCharacter,
                                    "Datorns karaktär: " + computerCharacter,
                                    "Vinnare: " + result,
                                    "-----------------------"
                            ),
                            StandardOpenOption.CREATE,
                            StandardOpenOption.APPEND
                    );


                }

                socket.close();



            }

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}



