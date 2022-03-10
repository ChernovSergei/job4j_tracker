package ru.job4j.tracker.poly;

public class Dispatcher {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] transports = new Vehicle[]{airplane, train, bus};
        for (Vehicle transport : transports) {
            transport.move();
        }
    }
}
