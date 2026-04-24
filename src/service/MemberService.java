package service;

import dto.MemberDto;

import java.util.List;

public interface MemberService {

    public int register(String userid, String password, String name, String tel, String cardnum, int isadmin);         // 회원가입

    public MemberDto login(String userId, String pw); // 로그인 (null 이면 실패)

    public List<MemberDto> getAll();                // 전체 회원 조회

    public int update(String userid, String password, String name, String tel, String cardnum, int isadmin);               // 회원 수정

    public int delete(int id);                      // 회원 삭제

    public int charge(int memberId, int amount);    // 잔액 충전
}
