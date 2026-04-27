package repository;

import state.MemberDto;
import state.MemberInfoDto;
import state.VendingState;

import java.util.ArrayList;
import java.util.List;

public class MemberRepositoryImpl implements MemberRepository{
    private final VendingState state;

    public MemberRepositoryImpl(VendingState state) {
        this.state = state;
    }

    @Override
    public int register(MemberInfoDto dto) {
        int result = state.insertData(dto);
        return result;
    }

    @Override
    public List<MemberDto> login(String userId, String pw) {
        return state.login(userId, pw);
    }

    @Override
    public List<MemberDto> findById(int id) {
        List<MemberDto> list = state.selectMember();
        List<MemberDto> result = new ArrayList<>();
        for (MemberDto i : list) {
            if (i.getId() == id) {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public List<MemberDto> findByUserId(String userid) {
        List<MemberDto> list = state.selectMember();
        List<MemberDto> result = new ArrayList<>();
        for (MemberDto i : list) {
            if (i.getUserId().equals(userid)) {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public List<MemberDto> findAll() {
        List<MemberDto> result = state.selectMember();
        return result;
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
