package ru.gb.jdk.lesson02.seminar02.task02;

public class ConsoleServerListner implements BaseListener {
    @Override
    public void genereateMessage(String msg) {
        System.out.println(msg);
    }
}
