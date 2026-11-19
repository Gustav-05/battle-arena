package main.serverclient;

import main.Character;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private PrintWriter out;

    public Client() throws IOException{
        Socket socket = new Socket("localhost", 5000);
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMatchData(String playerName, Character playerCharacter, Character computerCharacter, Character result) {
        out.println(playerName + ";" + playerCharacter.getName() + ";" + computerCharacter.getName() + ";" + result.getName());
    }


}
