package ru.gb.jdk.lesson05.homework;

public class Thinker {
    private int id;
    private boolean thinks;
    private boolean eating;
    private int countFood;

    Thinker(){
        this.id = (int) (Math.random() * 100);
        this.thinks = true;
        this.eating = false;
        this.countFood = 0;
    }

    public boolean getThinks() {
        return thinks;
    }

    public void setThinks(boolean thinks) {
        this.thinks = thinks;
    }

    public boolean getEating() {
        return eating;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }

    public int getId() {
        return id;
    }

    public int getCountFood() {
        return countFood;
    }

    public void setCountFood() {
        if(this.countFood != 3 && this.eating){
            this.countFood++;
        }
    }

    @Override
    public String toString() {
        return "Thinker " +
                "id = " + id +
                ", thinks = " + thinks +
                ", eating = " + eating +
                ", countFood = " + countFood;
    }
}
