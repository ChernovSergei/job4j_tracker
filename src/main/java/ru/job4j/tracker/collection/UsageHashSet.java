package ru.job4j.tracker.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<>();
        cars.add("Toyota");
        cars.add("Mistubishi");
        cars.add("Nisan");
        for (String carModel: cars) {
            System.out.println(carModel);
        }
    }
}
