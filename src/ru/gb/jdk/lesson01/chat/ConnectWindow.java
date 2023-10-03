package ru.gb.jdk.lesson01.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ConnectWindow extends JFrame{
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POS_X = 800;
    private static final int WINDOW_POS_Y = 300;
    private static final String WINDOW_NAME = "Подключение к серверу";

    private JTextField loginField = new JTextField("Введите ваш логин: ");
    private JTextField passwordField = new JTextField("Введите ваш пароль: ");
    private JTextField serverField = new JTextField("Введите IP-адреса сервера, порт подключения к серверу: ");

    private JButton btnConnect = new JButton("Подключиться");

    private JPanel grid = new JPanel(new GridLayout(4, 1));

    public ConnectWindow(){
        //свойства окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(WINDOW_NAME);
        setResizable(false);

        grid.add(loginField);
        grid.add(passwordField);
        grid.add(serverField);
        grid.add(btnConnect);

        getRootPane().setDefaultButton(btnConnect);
        btnConnect.setMnemonic(KeyEvent.VK_ENTER);

        add(grid);

        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText().replace("Введите ваш логин: ", "");
                new Chat(login);
            }
        });
        setVisible(true);

    }
}
