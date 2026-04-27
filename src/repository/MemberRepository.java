package repository;

import state.MemberDto;
import state.MemberInfoDto;

import java.util.List;

public interface MemberRepository {

    int register(MemberInfoDto dto);

    List<MemberDto> login(String userId, String pw);

    List<MemberDto> findById(int id);

    List<MemberDto> findByUserId(String userid);

    List<MemberDto> findAll();

    int update(MemberInfoDto dto);

    int delete(int id);

    int charge(int memberId, int amount);
}
