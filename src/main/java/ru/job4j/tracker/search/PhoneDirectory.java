package ru.job4j.tracker.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDirectory {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> compNames = (x) -> x.getName().contains(key);
        Predicate<Person> compSurnames = (x) -> x.getSurname().contains(key);
        Predicate<Person> compPhones = (x) -> x.getPhone().contains(key);
        Predicate<Person> compAdress = (x) -> x.getAddress().contains(key);

        Predicate<Person> combine = compNames.or(compSurnames.or(compPhones.or(compAdress)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person foundPerson: persons) {
            if (combine.test(foundPerson)) {
                result.add(foundPerson);
            }
        }
        return result;
    }
}
