package repository;

import state.MemberDto;
import state.MemberInfoDto;
import state.VendingState;

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
    public List<MemberDto> login(String userId, String pw) {
        return state.login(userId, pw);
    }

    @Override
    public List<MemberDto> findById(int id) {
        return List.of();
    }

    @Override
    public List<MemberDto> findByUserId(String userid) {
        return List.of();
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
