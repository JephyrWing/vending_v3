package service;

import dto.SalesDto;

import java.util.List;

public interface SalesService {
    List<SalesDto> getByMember(int memberId);           // 회원별 내역
    List<SalesDto> getSummaryByMenu();                  // 제품별 집계
    List<SalesDto> getSummaryByMember();                // 회원별 집계
}
