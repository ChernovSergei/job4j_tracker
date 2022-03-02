package ru.job4j.tracker.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return y + x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperations(int y, Calculator calc) {
        return sum(y) + calc.multiply(y) + minus(y) + calc.divide(y);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int y = 25;

        System.out.println(y + " + " + x + " = " + sum(y));
        System.out.println(y + " * " + x + " = " + calc.multiply(y));
        System.out.println(y + " - " + x + " = " + minus(y));
        System.out.println(y + " / " + x + " = " + calc.divide(y));
        System.out.println("All functions aggregation for " + y + " = " + calc.sumAllOperations(y, calc));
    }
}
