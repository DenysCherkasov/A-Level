package com.cherkasov.Action;

import com.cherkasov.model.Car;
import com.cherkasov.util.UserInput;

import java.util.Optional;

public class FindAction implements Action {
    @Override
    public void execute() {
        final String inputId = UserInput.inputId();
        Car foundedCar = CAR_SERVICE.find(inputId);
        if (foundedCar != null) {
            System.out.println("The car " + foundedCar);
        } else {
            System.out.println("The car is not found");
        }
    }
}