package repository;

import dto.MemberDto;
import dto.MemberInfoDto;

import java.util.List;

public interface MemberRepository {

    int register(MemberInfoDto dto);

    MemberDto login(String userId, String pw);

    List<MemberDto> findAll();

    int update(MemberInfoDto dto);

    int delete(int id);

    int charge(int memberId, int amount);
}
