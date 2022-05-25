package ru.job4j.tracker.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PhoneDirectoryTest {
    @Test
    public void whenFindName() {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add(new Person("Vasility", "Martunov", "longComplicatedPhoneNumber", "Borzya"));
        String key = "rtun";
        ArrayList<Person> persons = new ArrayList<>();
        persons = phoneDirectory.find(key);
        assertThat(persons.get(0).getSurname(), is("Martunov"));
    }

    @Test
    public void whenNoMatch() {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add(new Person("Vasility", "Martunov", "longComplicatedPhoneNumber", "Borzya"));
        String key = "tuun";
        ArrayList<Person> persons = new ArrayList<>();
        persons = phoneDirectory.find(key);
        assertThat(persons.size(), is(0));
    }
}
