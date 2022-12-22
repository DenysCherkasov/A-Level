package com.cherkasov.Action;

import com.cherkasov.util.AlgorithmUtil;
import com.cherkasov.util.UserInput;

public class SortCarAction implements Action {
    @Override
    public void execute() {
        System.out.println("How to sort cars?");
        String[] menu = {"Ascending", "Descending"};
        final int userChoice = UserInput.menu(menu);
        if (userChoice == 0) {
            AlgorithmUtil.bubbleSortCars(CAR_SERVICE.getAll());
        }
        if (userChoice == 1) {
            AlgorithmUtil.bubbleSortCarsDescending(CAR_SERVICE.getAll());
        }
    }
}
