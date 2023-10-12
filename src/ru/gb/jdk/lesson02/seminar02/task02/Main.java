package ru.gb.jdk.lesson02.seminar02.task02;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new ChatWindow(new ConsoleServerListner(), new Server(new LogServerListener("ServerLogFile.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
