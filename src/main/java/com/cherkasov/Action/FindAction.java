package com.cherkasov.Action;

import com.cherkasov.model.Car;
import com.cherkasov.util.UserInput;

import java.util.Optional;

public class FindAction implements Action {
    @Override
    public void execute() {
        final String inputId = UserInput.inputId();
        CAR_SERVICE.find(inputId)
                .ifPresentOrElse(car -> System.out.println("The car " + car),
                        () ->System.out.println("The car is not found"));
    }
}