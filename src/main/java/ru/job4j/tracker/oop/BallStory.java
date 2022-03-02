package ru.job4j.tracker.oop;

public class BallStory {
    public static void main(String[] args) {
        Hare judyHopps = new Hare();
        Wolf scottCohen = new Wolf();
        Fox huliJing = new Fox();
        Ball mikeWazowski = new Ball();
        judyHopps.tryEat(mikeWazowski, false);
        scottCohen.tryEat(mikeWazowski, false);
        huliJing.tryEat(mikeWazowski, true);
    }
}
