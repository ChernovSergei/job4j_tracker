package ru.job4j.tracker.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDirectoryTest {
    @Test
    public void whenFindName() {
        var phoneDirectory = new PhoneDirectory();
        phoneDirectory.add(new Person("Vasility", "Martunov", "longComplicatedPhoneNumber", "Borzya"));
        var key = "rtun";
        ArrayList<Person> persons = new ArrayList<>();
        persons = phoneDirectory.find(key);
        assertThat(persons.get(0).getSurname(), is("Martunov"));
    }

    @Test
    public void whenNoMatch() {
        var phoneDirectory = new PhoneDirectory();
        phoneDirectory.add(new Person("Vasility", "Martunov", "longComplicatedPhoneNumber", "Borzya"));
        var key = "tuun";
        ArrayList<Person> persons = new ArrayList<>();
        persons = phoneDirectory.find(key);
        assertThat(persons.size(), is(0));
    }

    @Test
    public void whenFindByName() {
        var phones = new PhoneDirectory();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }
}
