package com.cherkasov.Action;

public class ExitAction implements Action {
    @Override
    public void execute() {
        System.out.println("Bye!");
        System.exit(0);
    }
}

