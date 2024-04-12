package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Car[] cars = new Car[3];
        cars[0] = new Car("Toyota Supra", new Engine("R6", 3.0), new Body(Color.czarny), new Wheels(300));
        cars[1] = new Car("BMW X6", new Engine("V8", 4.4), new Body(Color.biały), new Wheels(280));
        cars[2] = new Car("Honda Civic", new Engine("V TURBO", 2.0), new Body(Color.czerwony), new Wheels(290));

        System.out.println("Auta przed naprawą:\n");

        for (int i=0;i<3;i++) {
            System.out.println(cars[i]);
        }

        repairForEach(cars);
        repairFor(cars);
        repairStreams(cars);

        System.out.println("\nAuta po naprawie:\n");

        for (int i=0;i<3;i++) {
            System.out.println(cars[i]);
        }
    }

    public static void repairForEach(Car[] cars) {
        for (Car car : cars) {
            CarFixService.repair(Errors.ENGINE_FAILURE, car);
        }
    }

    public static void repairFor(Car[] cars) {
        for (int i=0;i<3;i++) {
            CarFixService.repair(Errors.BODY_FAILURE, cars[i]);
        }
    }

    public static void repairStreams(Car[] cars) {
        Arrays.stream(cars).forEach(car -> CarFixService.repair(Errors.WHEELS_FAILURE, car));
    }
}