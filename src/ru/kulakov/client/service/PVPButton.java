package ru.kulakov.client.service;

import ru.kulakov.client.resource.ConnectData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PVPButton implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConnectData.setPort(1882);
    }
}
