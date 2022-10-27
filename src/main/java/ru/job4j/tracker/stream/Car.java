package ru.job4j.tracker.stream;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.BiFunction;

public class Car {
    private String brand;
    private String model;
    private LocalDate created;
    private double volume;
    private String color;
    private Car car;

    static class Builder {
        private String brand;
        private String model;
        private LocalDate created;
        private double volume;
        private String color;

        Builder buildBrand(String brand) {
            this.brand = brand;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildCreated(LocalDate created) {
            this.created = created;
            return this;
        }

        Builder buildVolume(double volume) {
            this.volume = volume;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.color = color;
            car.volume = volume;
            car.created = created;
            car.model = model;
            car.brand = brand;
            return car;
        }
    }

    @Override
    public String toString() {
            Predicate<Object> isNull = Objects::isNull;
            BiFunction<String, Object, String> getString = (s, o) -> isNull.test(o) ? "" : s + o.toString() + '\n';
            String result = "New car has been manufactured!" + '\n'
                    + getString.apply("Vintage: ", created)
                    + getString.apply("Brand: ", brand)
                    + getString.apply("Model: ", model)
                    + getString.apply("Color: ", color)
                    + getString.apply("Tank volume in litters: ", volume > 0 ? Double.toString(volume) : null);
            return result;
        }

        public static void main(String[] args) {
            Car toyota = new Builder()
                    .buildCreated(LocalDate.of(2017, 12, 29))
                    .buildBrand("Toyota")
                    .buildModel("Camry")
                    .buildVolume(2.5)
                    .buildColor("Red")
                    .build();
            Car ford = new Builder()
                    .buildBrand("Ford")
                    .buildColor("Dark Blue")
                    .build();
            System.out.println(toyota.toString());
            System.out.println(ford.toString());
        }
}
