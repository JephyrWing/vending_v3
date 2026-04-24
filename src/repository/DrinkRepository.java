package repository;

import state.DrinkDto;

import java.util.List;

public interface DrinkRepository {
    int insert(DrinkDto dto);                // 메뉴 추가

    int update(DrinkDto dto);                // 메뉴 수정

    int delete(int id);                      // 메뉴 삭제

    List<DrinkDto> findAll();                 // 전체 조회

    int sell(int memberId, int menuId);
}
