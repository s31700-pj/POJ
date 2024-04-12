package org.example;

public class CarFixService {
    public static Car repair(Errors error, Car car) {
        if (error == Errors.ENGINE_FAILURE) {
            return repairEngine(car);
        } else if (error == Errors.BODY_FAILURE) {
            return repairBody(car);
        } else if (error == Errors.WHEELS_FAILURE) {
            return repairWheels(car);
        } else {
            System.out.println("Błąd");
            return car;
        }

    }

    private static Car repairWheels(Car car) {
        Wheels newWheels = new Wheels(330);
        car.setWheels(newWheels);
        return car;
    }

    private static Car repairEngine(Car car) {
        Engine newEngine = new Engine("V8",3.9);
        car.setEngine(newEngine);
        return car;
    }

    private static Car repairBody(Car car) {
        Body newBody = new Body(Color.biały);
        car.setBody(newBody);
        return car;
    }

}
