package ru.job4j.tracker.stream;

import java.util.stream.Stream;

public class CardDeck {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(x -> Stream.of(Value.values())
                        .map(y -> new Card(x, y)))
                .forEach(System.out::println);
    }
}
