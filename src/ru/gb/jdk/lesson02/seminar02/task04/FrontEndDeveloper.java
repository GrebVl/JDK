package ru.gb.jdk.lesson02.seminar02.task04;

public class FrontEndDeveloper extends Developer implements FronteEndProgramming{
    @Override
    void drinkCoffee() {
        System.out.println("Drink coffee");
    }

    @Override
    void smoke() {
        System.out.println("smoke");
    }

    @Override
    public void developGUI() {
        System.out.println("create GUI");

    }
}
