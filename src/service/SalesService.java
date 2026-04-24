package service;

import dto.SalesDto;

import java.util.List;

public interface SalesService {
    public List<SalesDto> getByMember(int memberId);           // 회원별 내역
    public List<SalesDto> getSummaryByMenu();                  // 제품별 집계
    public List<SalesDto> getSummaryByMember();                // 회원별 집계
}
