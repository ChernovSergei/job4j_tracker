package ru.job4j.tracker.oop;

public class Reduce {
    private int[] array;

    public void to(int[] array) {
        this.array = array;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] primeNumbers = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(primeNumbers);
        reduce.print();
    }
}
