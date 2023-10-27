package ru.gb.jdk.lesson04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PeopleList {
    private ArrayList<Person> people;

    public PeopleList(String phone, String name, int experience){
        people = new ArrayList<>();
        people.add(new Person(0, phone, name, experience));
    }

    public Person findByExperience(int experience) {
        assert people != null : "LIST";
        var opt = people.stream().filter(p -> p.getExperience() == experience).findAny();
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    public List<String> findPhonesByName(String name) {
        return people.stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .map(p -> p.getPhone()).collect(Collectors.toList());
    }

    public <R> List<R> findSomething(Predicate<Person> filter, Function<Person, R> mapper) {
        return people.stream().filter(filter).map(mapper).collect(Collectors.toList());
    }

    public void addList(String phone, String name, int experience) {
        int lastId = people.stream().mapToInt(Person::getPersonId).max().getAsInt();
        people.add(new Person(lastId + 1, phone, name, experience));
    }

    public ArrayList<Person> getPeople() {
        return people;
    }
}
