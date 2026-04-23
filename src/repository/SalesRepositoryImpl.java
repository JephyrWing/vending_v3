package repository;

import java.sql.Connection;

public class SalesRepositoryImpl implements SalesRepository{
    private final Connection conn;

    public SalesRepositoryImpl(Connection conn) {
        this.conn = conn;
    }
}
