package ru.job4j.tracker.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        String[] ballAnswer = {"Yes", "No", "Maybe"};
        String ballQuestion = "I am Great Oracle. What are you eager to know?";
        Scanner input = new Scanner(System.in);

        System.out.println(ballQuestion);
        String userQuestioin = input.nextLine();
        int index = new Random().nextInt(3);
        System.out.println(ballAnswer[index]);
    }
}
