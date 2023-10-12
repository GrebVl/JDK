package ru.gb.jdk.lesson02.seminar02.task04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Developer> developers = new ArrayList<>();

        int tempInt = rand.nextInt(100);
        for (int i = 0; i < tempInt; i++) {
            if (rand.nextBoolean()) {
                developers.add(new FrontEndDeveloper());
            } else {
                developers.add(new BackEndDeveloper());
            }

        }

        for (Developer developer : developers) {
            checkSpec(developer);
        }

        var test1 = new BackEndProgramming() {
            @Override
            public void developAPI() {
            }
        };


        var test2 = new BackEndProgramming() {
            @Override
            public void developAPI() {
            }
        };

        System.out.println(test1.getClass().toString());
        System.out.println(test2.getClass().toString());
        System.out.println("___________________");
        for (Developer developer : developers) {
            checkSpec1(developer);
        }
    }

    static void checkSpec1(Developer developer) {
        if (developer instanceof FrontEndDeveloper) {
            ((FrontEndDeveloper) developer).developGUI();
        }
        if (developer instanceof BackEndDeveloper) {
            ((BackEndDeveloper) developer).developAPI();
        }
    }

    static void checkSpec(Developer developer) {
        if (developer instanceof FrontEndDeveloper) {
            ((FrontEndDeveloper) developer).developGUI();
        } else {
            System.out.println("Create GUI not supported by this Developer");
        }
    }
}
