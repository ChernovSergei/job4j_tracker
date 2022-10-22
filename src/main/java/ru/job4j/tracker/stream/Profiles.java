package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(x -> x.getAddress())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
