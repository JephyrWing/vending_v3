package repository;

import java.sql.Connection;

public class DrinkRepositoryImpl implements DrinkRepository{
    private final Connection conn;

    public DrinkRepositoryImpl(Connection conn) {
        this.conn = conn;
    }
}
