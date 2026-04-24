package service;

import dto.DrinkDto;
import dto.MemberDto;

import java.util.List;

public interface DrinkService {

    public int insert(String name, int price, int stock);                // 메뉴 추가

    public int update(String name, int price, int stock);                // 메뉴 수정

    public int delete(int id);                      // 메뉴 삭제

    public List<DrinkDto> getAll();                 // 전체 조회

    public int sell(int memberId, int menuId);      // 구매 처리
}
