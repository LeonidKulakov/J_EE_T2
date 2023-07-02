package ru.kulakov.client.view;

import ru.kulakov.client.service.DefeatButton;
import ru.kulakov.client.service.DrawButton;
import ru.kulakov.client.service.InfoButton;
import ru.kulakov.client.service.PaperButton;
import ru.kulakov.client.service.RockButton;
import ru.kulakov.client.service.ScissorsButton;

import javax.swing.*;
import java.awt.*;

public class ClientGame extends JFrame {
    private JTextField input;
    private JButton rock;
    private JButton paper;
    private JButton scissors;
    private JButton draw;
    private JButton defeat;
    private JButton info;

    public ClientGame() {
        super("Game");

        this.setBounds(300, 300, 300, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 1, 5, 5));

        container.add(new JLabel("Имя пользователя"));
        input = new JTextField(null, 2);
        container.add(input);

        container.add(new JLabel("Выбор предмета"));

        rock = new JButton("Камень");
        rock.addActionListener(new RockButton());
        container.add(rock);

        paper = new JButton("Бумага");
        paper.addActionListener(new PaperButton());
        container.add(paper);

        scissors = new JButton("Ножницы");
        scissors.addActionListener(new ScissorsButton());
        container.add(scissors);

        container.add(new JLabel("Особые действия"));

        defeat = new JButton("Сдаться");
        defeat.addActionListener(new DefeatButton());
        container.add(defeat);

        draw = new JButton("Ничья");
        draw.addActionListener(new DrawButton());
        container.add(draw);

        info = new JButton("Информация");
        info.addActionListener(new InfoButton(this));
        container.add(info);



    }

    // Получить текст из поля можно с помощью getInput().getText()
    // Введите текст в поле и нажмите кнопку информации
    public JTextField getInput() {
        return input;
    }
}
