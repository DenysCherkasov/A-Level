package com.cherkasov.Action;

import com.cherkasov.util.UserInput;

public class DeleteCarAction implements Action {
    @Override
    public void execute() {
        final String inputId = UserInput.inputId();
        CAR_SERVICE.delete(inputId);
    }
}
