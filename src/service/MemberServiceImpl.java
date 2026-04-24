package service;

import dto.MemberDto;
import repository.MemberRepository;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository repository;

    public MemberServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public int register(String userid, String password, String name, String tel, String cardnum, int isadmin) {
        return 0;
    }

    @Override
    public MemberDto login(String userId, String pw) {
        return null;
    }

    @Override
    public List<MemberDto> getAll() {
        return List.of();
    }

    @Override
    public int update(String userid, String password, String name, String tel, String cardnum, int isadmin) {
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
