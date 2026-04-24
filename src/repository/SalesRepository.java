package repository;

import dto.SalesDto;

import java.util.List;

public interface SalesRepository {
    List<SalesDto> findByMember(int memberId);
    List<SalesDto> findSummaryByMenu();
    List<SalesDto> findSummaryByMember();
}
