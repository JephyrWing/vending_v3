package repository;

import dto.MemberDto;
import dto.MemberInfoDto;
import state.VendingState;

import java.sql.Connection;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository{
    private final VendingState state;

    public MemberRepositoryImpl(VendingState state) {
        this.state = state;
    }

    @Override
    public int register(MemberInfoDto dto) {
        return 0;
    }

    @Override
    public MemberDto login(String userId, String pw) {
        return null;
    }

    @Override
    public List<MemberDto> findAll() {
        return List.of();
    }

    @Override
    public int update(MemberInfoDto dto) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int charge(int memberId, int amount) {
        return 0;
    }
}
