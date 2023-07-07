package ru.kulakov.client.service;

import ru.kulakov.client.view.ClientGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoButton implements ActionListener {

    private ClientGame clientGame;

    public InfoButton(ClientGame clientGame) {
        this.clientGame = clientGame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(clientGame.getInput().getText());
        // Описание активности
    }
}
