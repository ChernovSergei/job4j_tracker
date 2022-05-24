package ru.job4j.tracker.search;

import java.util.ArrayList;

public class PhoneDirectory {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person foundPerson: persons) {
            if (foundPerson.getName().contains(key)
                    || foundPerson.getSurname().contains(key)
                    || foundPerson.getPhone().contains(key)
                    || foundPerson.getAddress().contains(key)) {
                result.add(foundPerson);
            }
        }
        return result;
    }
}
