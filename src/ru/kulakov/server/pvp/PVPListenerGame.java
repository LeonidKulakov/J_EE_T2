package ru.kulakov.server.pvp;

import ru.kulakov.server.service.PlayService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PVPListenerGame implements Runnable {

    private Socket playerOne;
    private Socket playerTwo;

    public PVPListenerGame(Socket playerOne, Socket playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    @Override
    public void run() {
        try (
                ObjectOutputStream oneOutputStream = new ObjectOutputStream(playerOne.getOutputStream());
                ObjectInputStream oneInputStream = new ObjectInputStream(playerOne.getInputStream());
                ObjectOutputStream twoOutputStream = new ObjectOutputStream(playerTwo.getOutputStream());
                ObjectInputStream twoInputStream = new ObjectInputStream(playerTwo.getInputStream());
        ){
            String playerOneMove = (String) oneInputStream.readObject();
            String playerTwoMove = (String) twoInputStream.readObject();

            String playerOneResponse = PlayService.timeToPlayTheGame(playerOneMove, playerTwoMove);
            String playerTwoResponse;
            switch (playerOneResponse){
                case "Ничья" -> playerTwoResponse = "Ничья";
                case "Победа" -> playerTwoResponse = "Поражение";
                case "Поражение" -> playerTwoResponse = "Победа";
                default -> playerTwoResponse = "Что то пошло не так";
            }

            oneOutputStream.writeObject(playerOneResponse);
            twoOutputStream.writeObject(playerTwoResponse);

            playerOne.close();
            playerTwo.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
