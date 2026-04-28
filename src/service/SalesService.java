package service;

import state.DrinkDto;
import state.SalesDto;
import state.SummaryDto;

import java.util.List;

public interface SalesService {
    List<SalesDto> getByMember(int memberId);           // 회원별 내역
    List<DrinkDto> getSummaryByMenu();                  // 제품별 집계
    List<SummaryDto> getSummaryByMember();
    int sell(int memberId, int menuId, int price);      // 구매 처리// 회원별 집계
}
