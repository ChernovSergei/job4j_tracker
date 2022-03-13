package ru.job4j.tracker.ex;

public class FindMaxLenght {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (int index = 0; index < shops.length; index++) {
            if (shops[index] == null) {
                continue;
            }
            String el = shops[index];
            if (el.length() > max) {
                max = el.length();
            }
        }
        System.out.println("Max length : " + max);
    }
}
