package ru.gb.jdk.lesson01.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;
    private int sizeX;
    private int sizeY;

    private static final Random RANDOM = new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private int EMPTY_DOT = 0;
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private  char[][] field;


    Map(int sizeX, int sizeY){
        /**
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
         */
        this.sizeX = sizeX;
        this.sizeY = sizeY;

    }

    void startNewGame(boolean mode, int fSzX, int fSzY, int wLen){
        this.sizeX = fSzX;
        this.sizeY = fSzY;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g){
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        cellHeight = panelHeight / this.sizeX;
        cellWidth = panelWidth / this.sizeY;

        g.setColor(Color.DARK_GRAY);
        for(int h = 0; h < this.sizeX; h++){
            int y = h *cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for(int w = 0; w < this.sizeY; w++){
            int x = w *cellWidth;
            g.drawLine(x,0, x, panelHeight);
        }
        repaint();
    }

    private void update(MouseEvent e){
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.printf("x=%d, y=%d\n", cellX, cellY);
        if(!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        repaint();
    }

    private void initMap(){
        fieldSizeY = 3;
        fieldSizeY = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for(int i = 0; i<fieldSizeY; i++){
            for(int j=0; j<fieldSizeX; j++){
                field[i][j] = (char) EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y){
        return x>= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y){
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn(){
        int x, y;
        do{
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        }while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean checkWin(char c){
        for(int i = 0; i < fieldSizeX; i ++){
            if(field[i][0] == c && field[i][1] == c && field[i][2] == c) return true;
            if(field[0][i] == c && field[1][i] == c && field[2][i] == c) return true;
        }
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }

    private boolean isMapFull(){
        for (int i = 0; i < fieldSizeY; i++){
            for (int j = 0; j < fieldSizeX; j++){
                if(field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
}
