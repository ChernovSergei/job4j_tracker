package ru.job4j.tracker.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDirectory {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = (x) -> (
                x.getName().contains(key)
                || x.getSurname().contains(key)
                || x.getPhone().contains(key)
                || x.getAddress().contains(key)
        );
        ArrayList<Person> result = new ArrayList<>();
        for (Person foundPerson: persons) {
            if (combine.test(foundPerson)) {
                result.add(foundPerson);
            }
        }
        return result;
    }
}
