package ru.kulakov.client.service;

import ru.kulakov.client.resource.ConnectData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RockButton implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Socket client = new Socket(ConnectData.getIP(), ConnectData.getPort());
            ObjectOutputStream outputStream = new ObjectOutputStream(client.getOutputStream());
            outputStream.writeObject("Камень");
            ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
            JOptionPane.showMessageDialog(null, inputStream.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
