package ru.gb.jdk.lesson01.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POS_X = 800;
    private static final int WINDOW_POS_Y = 300;

    Map map;
    SettingsWindow settings;

    //элементы нижняя часть
    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");


    GameWindow() {
        //свойства окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);

        //элементы основная часть
        settings = new SettingsWindow(this);
        map = new Map(settings.sliderSizeValue, settings.sliderSizeValue);

        //обработчики кнопок
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        //отрисовка
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(map);
        map.setVisible(false);
        setVisible(true);
    }

    void startNewGame(boolean mode, int fSzX, int fSzY, int wLen) {
        map.setVisible(true);
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
