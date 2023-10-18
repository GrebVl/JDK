package ru.gb.jdk.lesson03.homework.task02;

public class Calculator {

    public <T> T sum(T a, T b) {
        if(a instanceof Integer)
            return (T) (Integer.valueOf(((Integer) a).intValue() + ((Integer) b).intValue()));
        else if(a instanceof Double)
            return (T) (Double.valueOf(((Double) a).doubleValue() + ((Double) b).doubleValue()));
        else if(a instanceof Float)
            return (T) (Float.valueOf(((Float) a).floatValue() + ((Float) b).floatValue()));
        return null;
    }

    public <T> T sub(T a, T b) {
        if(a instanceof Integer)
            return (T) (Integer.valueOf(((Integer) a).intValue() - ((Integer) b).intValue()));
        else if(a instanceof Double)
            return (T) (Double.valueOf(((Double) a).doubleValue() - ((Double) b).doubleValue()));
        else if(a instanceof Float)
            return (T) (Float.valueOf(((Float) a).floatValue() - ((Float) b).floatValue()));
        return null;
    }

    public <T> T mul(T a, T b) {
        if(a instanceof Integer)
            return (T) (Integer.valueOf(((Integer) a).intValue() / ((Integer) b).intValue()));
        else if(a instanceof Double)
            return (T) (Double.valueOf(((Double) a).doubleValue() / ((Double) b).doubleValue()));
        else if(a instanceof Float)
            return (T) (Float.valueOf(((Float) a).floatValue() / ((Float) b).floatValue()));
        return null;
    }

    public <T> T div(T a, T b) {
        if(a instanceof Integer)
            return (T) (Integer.valueOf(((Integer) a).intValue() * ((Integer) b).intValue()));
        else if(a instanceof Double)
            return (T) (Double.valueOf(((Double) a).doubleValue() * ((Double) b).doubleValue()));
        else if(a instanceof Float)
            return (T) (Float.valueOf(((Float) a).floatValue() * ((Float) b).floatValue()));
        return null;
    }

}
