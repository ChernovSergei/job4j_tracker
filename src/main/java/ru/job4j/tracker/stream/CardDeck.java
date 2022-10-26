package ru.job4j.tracker.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeck {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(x -> Stream.of(Value.values())
                        .map(y -> new Card(x, y).toString()))
                .forEach(System.out::println);
    }
}
