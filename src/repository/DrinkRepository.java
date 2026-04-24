package repository;

import dto.DrinkDto;

import java.util.List;

public interface DrinkRepository {
    public int insert(DrinkDto dto);                // 메뉴 추가

    public int update(DrinkDto dto);                // 메뉴 수정

    public int delete(int id);                      // 메뉴 삭제

    public List<DrinkDto> findAll();                 // 전체 조회

    public int sell(int memberId, int menuId);
}
