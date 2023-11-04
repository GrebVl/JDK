package ru.gb.jdk.lesson05.homework;

import java.util.Random;

/**
 * Есть пять философов (потоки), которые могут либо обедать либо размышлять.
 * Каждый философ должен пообедать три раза.
 * Каждый прием пищи длиться 500 миллисекунд
 * После каждого приема пищи философ должен размышлять
 * Не должно возникнуть общей блокировки
 * Философы не должны есть больше одного раза подряд
 * <p>
 * Дополнение
 * <p>
 * Реализовать много поточное приложение имитирующее работу месенджера:
 * Хранение и работа с логом чата проводится в основном потоке
 * Остальные потоки - клиенты, хранят в себе имя пользователя,
 * имет графическую оболочку отображающую чат и позволяющую отправлять сообщения в чат
 */

public class Main {
    static boolean foodTable = false;
    static Random rnd = new Random();

    public static void main(String[] args) {
        Thinker[] thinkers = new Thinker[5];
        for (int i = 0; i < thinkers.length; i++) {
            thinkers[i] = new Thinker();
            System.out.println(thinkers[i].toString());
        }

        Thread[] threads = new Thread[5];

        for(int j = 0; j < threads.length; j++){
            int number = j;
            threads[number] = new Thread(() -> {
                int count = 0;
                try {
                    while (count != 3) {
                        if(!foodTable && thinkers[number].getCountFood() != 3){
                            dinner(thinkers[number]);
                            count++;
                        }else{
                            System.out.print(".");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for(int r = 0; r < threads.length; r++){
            threads[r].start();
        }


        /**
        Thread threadA = new Thread(() -> {
            int count = 0;
            try {
                while (count != 3) {
                    if(!foodTable && thinkers[0].getCountFood() != 3){
                        dinner(thinkers[0]);
                        count++;
                    }else{
                        System.out.print(".");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread threadB = new Thread(() -> {
            int count = 0;
            try {
                while (count != 3) {
                    if(!foodTable && thinkers[1].getCountFood() != 3){
                        dinner(thinkers[1]);
                        count++;
                    }else{
                        System.out.print(".");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            int count = 0;
            try {
                while (count != 3) {
                    if(!foodTable && thinkers[2].getCountFood() != 3){
                        dinner(thinkers[2]);
                        count++;
                    }else{
                        System.out.print(".");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            int count = 0;
            try {
                while (count != 3) {
                    if(!foodTable && thinkers[3].getCountFood() != 3){
                        dinner(thinkers[3]);
                        count++;
                    }else{
                        System.out.print(".");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadI = new Thread(() -> {
            int count = 0;
            try {
                while (count != 3) {
                    if(!foodTable && thinkers[4].getCountFood() != 3){
                        dinner(thinkers[4]);
                        count++;
                    }else{
                        System.out.print(".");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadI.start();
         */

    }

    public static void dinner(Thinker thinker) throws InterruptedException {
            foodTable = true;
            thinker.setEating(true);
            System.out.println("Филосов " + thinker.getId() + " кушает");
            Thread.sleep(500);
            thinker.setCountFood();
            thinker.setEating(false);
            foodTable = false;
            Thread.sleep(rnd.nextInt(5000));
    }

}
