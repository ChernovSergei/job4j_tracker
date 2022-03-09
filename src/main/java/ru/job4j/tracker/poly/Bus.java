package ru.job4j.tracker.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("driving");
    }

    @Override
    public void passengers(int numberOfPassengers) {
        System.out.println("Passengers' quantity = " + numberOfPassengers);
    }

    @Override
    public int fillTank(int gasVolume) {
        return gasVolume * 3;
    }
}
