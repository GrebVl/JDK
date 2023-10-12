package ru.gb.jdk.lesson02.seminar02.task04;

public class BackEndDeveloper extends Developer implements BackEndProgramming{
    @Override
    public void developAPI() {
        System.out.println("create API");
    }

    @Override
    void drinkCoffee() {
        System.out.println("Drink coffee");
    }

    @Override
    void smoke() {
        System.out.println("smoke");
    }
}
