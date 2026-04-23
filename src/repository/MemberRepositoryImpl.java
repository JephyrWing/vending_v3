package repository;

import java.sql.Connection;

public class MemberRepositoryImpl implements MemberRepository{
    private final Connection conn;

    public MemberRepositoryImpl(Connection conn) {
        this.conn = conn;
    }
}
