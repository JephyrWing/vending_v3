package repository;

import state.VendingState;

import java.sql.Connection;

public class SalesRepositoryImpl implements SalesRepository{
    private final VendingState state;

    public SalesRepositoryImpl(VendingState state) {
        this.state = state;
    }
}
