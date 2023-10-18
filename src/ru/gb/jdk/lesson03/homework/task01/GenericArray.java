package ru.gb.jdk.lesson03.homework.task01;

import ru.gb.jdk.lesson03.semenar03.GenericIterator;

import java.util.Arrays;
import java.util.Iterator;

public class GenericArray<T> {
    GenericIterator<T> arrInterator;
    T[] array;

    public GenericArray() {
        this.arrInterator = new GenericIterator<>(this.array =(T[]) new Object[0]);
    }

    public void add(T t){
        T[] temp_arr = (T[]) new Object[array.length + 1];
        for (int i = 0; i < array.length; i++){
            temp_arr[i] = array[i];
        }
        temp_arr[array.length]= t;

        array = temp_arr;
        this.arrInterator = new GenericIterator<>(this.array);
    }

    public void remove(T t){
        Integer position = find(t);
        if(position != null){
            T[] temp_arr = (T[]) new Object[array.length - 1];
            for(int i = 0; i < position; i++){
                temp_arr[i] = array[i];
            }
            for(int j = position; j < array.length - 1; j++){
                temp_arr[j] = array[j + 1];
            }

            this.array = temp_arr;
        }
    }

    public Integer find(T t){
        while (arrInterator.hasNext()){
            if(arrInterator.next().equals(t)){
                return arrInterator.getIndex()-1;
            }
        }
        return null;
    }

    public String info(){
        return Arrays.toString(array);
    }

    public class GenericIterator <T> implements Iterator<T>, Iterable<T> {
        private T[] arr;
        private Integer index = 0;

        public GenericIterator(T[] arr) {
            this.arr = arr;
        }

        @Override
        public Iterator<T> iterator() {
            return new GenericIterator<>(arr);
        }

        @Override
        public boolean hasNext() {
            return (arr.length > index);
        }

        @Override
        public T next() {
            if(hasNext()){
                return arr[index++];
            }
            return null;
        }

        public Integer getIndex() {
            return index;
        }
    }
}
