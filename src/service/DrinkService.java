package service;

import dto.DrinkDto;
import dto.MemberDto;

import java.util.List;

public interface DrinkService {

    int insert(String name, int price, int stock);                // 메뉴 추가

    int update(String name, int price, int stock);                // 메뉴 수정

    int delete(int id);                      // 메뉴 삭제

    List<DrinkDto> getAll();                 // 전체 조회

    int sell(int memberId, int menuId);      // 구매 처리
}
