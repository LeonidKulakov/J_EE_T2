package ru.kulakov.server.pve;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PVEServerGame {

    private final int PORT = 1881;

    public static void main(String[] args) {
        PVEServerGame serverGame = new PVEServerGame();
        serverGame.createConnection();
    }
    public void createConnection(){
        try {
            var listener = new ServerSocket(PORT);
            Socket client;
            while (true){
                client = listener.accept();
                PVEListenerGame lG = new PVEListenerGame(client);
                Thread t = new Thread(lG);
                t.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
