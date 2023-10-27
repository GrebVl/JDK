package ru.gb.jdk.lesson04;


// Создать класс справочник сотрудников, который содержит внутри
// коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
// Табельный номер
// Номер телефона
// Имя
// Стаж
// Добавить метод, который ищет сотрудника по стажу (может быть список)
// Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
// Добавить метод, который ищет сотрудника по табельному номеру
// Добавить метод добавление нового сотрудника в справочник сотрудников


public class Main {
    public static void main(String[] args) {

        var people = new PeopleList("46456456", "Алекс", 10);
        people.addList("9575789", "Алекс", 12);
        people.addList("575756", "Василий", 8);
        people.addList("475675647", "Михаил", 9);
        people.addList("56457567657", "Анжелика", 11);
        people.addList("45757567", "Александра", 15);

        System.out.println("Сотрудник со стажем 8:" + people.findByExperience(8));
        Person pp = people.findByExperience(20);
        if (pp == null) {
            System.out.println("нет такого");

        } else {
            System.out.println("Сотрудник со стажем 20:" + pp);
        }

        people.addList("1456456", "Вася", 5);
        people.addList("45756", "Маша", 10);
        people.addList("56767657", "Коля", 20);

        people.getPeople().forEach(System.out::println);

        var phonesByName = people.findPhonesByName("Алеj");
        System.out.println("Сотрудники по имени Алекс : " +phonesByName);

        var idsByName = people.findSomething(p -> p.getName() == "Анжелика", p -> p.getPersonId());
        System.out.println("ID'шники Анжелики: " + idsByName);
    }
}


