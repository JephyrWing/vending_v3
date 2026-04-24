package service;

import state.MemberDto;
import repository.MemberRepository;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public int register(String userid, String password, String name, String tel, String cardnum) {
        return 0;
    }

    @Override
    public int[] login(String userId, String pw) {
        int[] result = null;
        List<MemberDto> list = repository.login(userId, pw);
        if (!list.isEmpty()) {
            result = new int[] {list.get(0).getId(), list.get(0).getIsAdmin()};
        }

        return result;
    }

    @Override
    public List<MemberDto> getAll() {
        return List.of();
    }

    @Override
    public int update(String userid, String password, String name, String tel, String cardnum) {
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

    @Override
    public boolean checkUserId(String user_id) {
        return false;
    }

    @Override
    public boolean checkPass(String pass, String passConfirm) {
        return false;
    }

    @Override
    public boolean checkTel(String tel) {
        return false;
    }

    @Override
    public boolean checkCard(String cardNum) {
        return false;
    }
}
