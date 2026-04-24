package repository;

import state.VendingState;

import java.sql.Connection;

public class DrinkRepositoryImpl implements DrinkRepository{
    private final VendingState state;

    public DrinkRepositoryImpl(VendingState state) {
        this.state = state;
    }
}
