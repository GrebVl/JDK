package ru.gb.jdk.lesson02.seminar02.task01;

public class ConsoleServerListner implements ServerListner{
    @Override
    public void genereateMessage(String msg) {
        System.out.println(msg);
    }
}
