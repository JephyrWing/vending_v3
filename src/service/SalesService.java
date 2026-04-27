package service;

import state.SalesDto;

import java.util.List;

public interface SalesService {
    List<SalesDto> getByMember(int memberId);           // 회원별 내역
    List<SalesDto> getSummaryByMenu();                  // 제품별 집계
    List<SalesDto> getSummaryByMember();
    int sell(int memberId, int menuId, int price);      // 구매 처리// 회원별 집계
}
