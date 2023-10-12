package ru.gb.jdk.lesson02.seminar02.task01;

public class Main {
    public static void main(String[] args) {
        new ChatWindow(new Server(new ConsoleServerListner()));
    }
}
