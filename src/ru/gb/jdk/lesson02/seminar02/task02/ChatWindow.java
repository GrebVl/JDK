package ru.gb.jdk.lesson02.seminar02.task02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame implements ClientListener{
    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JPanel grid;
    Server server;
    BaseListener listener;
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    ChatWindow(BaseListener listener, Server server){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.server = server;
        this.listener = listener;
        grid = new JPanel(new GridLayout(1, 2));
        grid.add(btnStart);
        grid.add(btnStop);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
                event("Нажата кнопка пуск сервер");
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
                event("Нажата кнопка стоп сервер");
            }
        });

        add(grid);
        setVisible(true);
    }

    @Override
    public void event(String msg) {
        listener.genereateMessage(msg);

    }
}
