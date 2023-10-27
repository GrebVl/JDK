package ru.gb.jdk.lesson04;

public class Person {
    private int personId;
    private String phone;
    private String name;
    private int experience;

    public Person(int personId, String phone, String name, int experience) {
        this.personId = personId;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public int getPersonId() {
        return personId;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("Табельный номер: %d, Имя: %s, Телефон: %s, Стаж: %d", personId, name, phone, experience);
    }
}
