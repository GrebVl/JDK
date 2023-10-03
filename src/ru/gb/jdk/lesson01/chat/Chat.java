package ru.gb.jdk.lesson01.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POS_X = 800;
    private static final int WINDOW_POS_Y = 300;
    private Log log;

    private static final String WINDOW_NAME = "Чат с сервером";

    private JTextArea textOutput = new JTextArea("просмотр сообщений чата\n");
    private JTextField textInput = new JTextField("Введите собщение серверу: ");

    private JButton btnStart = new JButton("Отправить собщение");
    JButton btnExit = new JButton("Exit");

    private JPanel grid = new JPanel(new GridLayout(4, 1));

    public Chat(String login){
        log = new Log(login);
        //свойства окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(WINDOW_NAME);
        setResizable(false);

        textOutput.setEditable(false);
        textOutput.setBackground(Color.CYAN);
        grid.add(textOutput);
        grid.add(textInput);
        grid.add(btnStart);
        grid.add(btnExit);

        if(log.isAvailability()){
            for(int i = 0; i < log.getLogArr().size(); i++){
                textOutput.append(login + ": " + log.getLogArr().get(i) + "\n");
            }
        }

        getRootPane().setDefaultButton(btnStart);
        btnStart.setMnemonic(KeyEvent.VK_ENTER);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textInput.getText().replace("Введите собщение серверу: ", "");
                textOutput.append(login + ": " + message + "\n");
                log.getLogArr().add(message);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.writer();
                System.exit(0);
            }
        });


        add(grid);
        setVisible(true);
    }
}
