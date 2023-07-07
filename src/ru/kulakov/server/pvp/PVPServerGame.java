package ru.kulakov.server.pvp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PVPServerGame {
    private static final int PORT = 1882;

    public static void main(String[] args) {
        PVPServerGame pvpServerGame = new PVPServerGame();
        pvpServerGame.createConnection();
    }

    public void createConnection() {
        try {
            var listener = new ServerSocket(PORT);
            Socket clientOnw;
            Socket clientTwo;
            while (true) {
                clientOnw = listener.accept();
                clientTwo = listener.accept();
                Thread t = new Thread(new PVPListenerGame(clientOnw,clientTwo));
                t.start();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
