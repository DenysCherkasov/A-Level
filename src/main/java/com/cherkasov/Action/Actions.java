package com.cherkasov.Action;

import lombok.Getter;

@Getter
public enum Actions {
    CREATE("Create cars", new CreateAction()),
    SHOW_ALL("Show all cars", new ShowAllAction()),
    SORT_CAR_ACTION("Sort all cars", new SortCarAction()),
    FIND_CAR("Find car", new FindAction()),
    FINDACTIONBINARYSEARCH("Find index of car", new FindActionBinarySearch()),
    DELETE_CAR("Delete car", new DeleteCarAction()),
    EXIT("Finish program", new ExitAction());

    private final String name;
    private final Action action;

    Actions(final String name, final Action action) {
        this.name = name;
        this.action = action;
    }

    public void execute() {
        action.execute();
    }

}
