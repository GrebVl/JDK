package ru.gb.jdk.lesson03.homework;

import ru.gb.jdk.lesson03.homework.task01.GenericArray;
import ru.gb.jdk.lesson03.homework.task02.Calculator;
import ru.gb.jdk.lesson03.homework.task04.Pair;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        /** TASK 01
        GenericArray<Integer> array = new GenericArray<>();
        System.out.println(array.info());
        array.add(1);
        System.out.println(array.info());
        array.add(2);
        System.out.println(array.info());
        array.add(3);
        System.out.println(array.info());
        array.remove(2);
        System.out.println(array.info());
        array.add(3);
        System.out.println(array.info());
        array.remove(1);
        System.out.println(array.info());
         */

        /** TASK 02
        Calculator k = new Calculator();
        System.out.println(k.sum(2, 3));
        System.out.println(k.sub(5.2, 1.3));
        System.out.println(k.mul(6, 3));
        System.out.println(k.div(7, 3));
         */

        Integer[] arrA = new Integer[]{1,2,3};
        Integer[] arrB = new Integer[]{4,5,6};
        Integer[] arrI = new Integer[]{1,2,3};
        String[] arrC = new String[]{"a","b","c"};
        String[] arrD = new String[]{"a","b","c"};
        System.out.println(compareArrays(arrA, arrB));
        System.out.println(compareArrays(arrA, arrI));
        System.out.println(compareArrays(arrA, arrC));
        System.out.println(compareArrays(arrC, arrD));

        /**TASK 04
        Pair<Integer, String> pair = new Pair<>(5, "task04");
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println(pair.toString());
         */




    }

    public static <E> boolean compareArrays(E[] arrA, E[] arrB){
        if (arrA == null || arrB == null) {
            throw new NullPointerException("array null");
        }
        if (arrA.length != arrB.length) {
            return false;
        }
        for (int i = 0; i < arrA.length; ++i) {
            if (!Objects.equals(arrA[i], arrB[i])) {
                return false;
            }
        }
        return true;
    }
}
