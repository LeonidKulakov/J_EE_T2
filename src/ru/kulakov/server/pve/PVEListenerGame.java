package ru.kulakov.server.pve;

import ru.kulakov.server.service.PlayService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PVEListenerGame implements Runnable {
    private Socket socket;

    public PVEListenerGame(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (var outputStream = new ObjectOutputStream(socket.getOutputStream());
             var inputStream = new ObjectInputStream(socket.getInputStream())
        ) {
            String playerMove = (String) inputStream.readObject();
            String virtualEnemyMove = PlayService.getMove();
            outputStream.writeObject(PlayService.timeToPlayTheGame(playerMove, virtualEnemyMove));
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
