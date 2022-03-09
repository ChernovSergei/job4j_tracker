package ru.job4j.tracker.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Game 11");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "First gamer" : "Second gamer";
            System.out.println(player + ", enter number of matches from 1 to 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 3 || matches <= 0) {
                System.out.println("Error. The number of entered matches exceed limits from 1 to 3");
                continue;
            }
            if (matches > count) {
                System.out.println("Error. The number of entered matches is above left matches quantity: " + count);
                continue;
            }
            turn = !turn;
            count -= matches;
            System.out.println("Remaining matches = " + count);
        }
        if (!turn) {
            System.out.println("First gamer is the winner");
        } else {
            System.out.println("Second gamer is the winner");
        }
    }
}
