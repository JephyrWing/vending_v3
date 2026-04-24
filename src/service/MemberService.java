package service;

import dto.MemberDto;

import java.util.List;

public interface MemberService {

    int register(String userid, String password, String name, String tel, String cardnum);         // 회원가입

    MemberDto login(String userId, String pw); // 로그인 (null 이면 실패)

    List<MemberDto> getAll();                // 전체 회원 조회

    int update(String userid, String password, String name, String tel, String cardnum);               // 회원 수정

    int delete(int id);                      // 회원 삭제

    int charge(int memberId, int amount);    // 잔액 충전

    boolean checkUserId(String user_id);

    boolean checkPass(String pass, String passConfirm);

    boolean checkTel(String tel);

    boolean checkCard(String cardNum);
}
