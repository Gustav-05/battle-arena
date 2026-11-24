package main.serverclient;

import main.Character;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

    private PrintWriter out;

    public Client() throws IOException{
        Socket socket = new Socket("localhost", 5000);
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMatchData(Character playerCharacter, Character computerCharacter, Character result) {

        String data =
                        playerCharacter.getName() + ";" +
                        computerCharacter.getName() + ";" +
                        result.getName();

        out.println(data);
    }
}
