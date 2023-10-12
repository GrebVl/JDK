package ru.gb.jdk.lesson02.seminar02.task03;

public class FullStackProgrammer implements BackEndProgramming, FronteEndProgramming{
    @Override
    public void writeBackEndCode() {
        System.out.println("Пишет фронтенд");
    }

    @Override
    public void writeFrontEndCode() {
        System.out.println("Пишет бэкенд");
    }
}
