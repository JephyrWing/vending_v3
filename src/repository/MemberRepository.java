package repository;

import dto.MemberDto;
import dto.MemberInfoDto;

import java.util.List;

public interface MemberRepository {

    public int register(MemberInfoDto dto);

    public int login(String userId, String pw);

    public List<MemberDto> findAll();

    public int update(MemberInfoDto dto);

    public int delete(int id);

    public int charge(int memberId, int amount);
}
