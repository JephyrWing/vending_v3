package repository;

import state.VendingState;

import java.sql.Connection;

public class MemberRepositoryImpl implements MemberRepository{
    private final VendingState state;

    public MemberRepositoryImpl(VendingState state) {
        this.state = state;
    }
}
