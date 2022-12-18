package com.cherkasov.Action;

import com.cherkasov.service.CarService;

public interface Action {

    CarService CAR_SERVICE = CarService.getInstance();

    void execute();
}