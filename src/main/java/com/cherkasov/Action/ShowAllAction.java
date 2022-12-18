package com.cherkasov.Action;

public class ShowAllAction implements Action {
    @Override
    public void execute() {
        CAR_SERVICE.printAll();
    }
}
