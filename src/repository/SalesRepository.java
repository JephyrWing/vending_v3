package repository;

import dto.SalesDto;

import java.util.List;

public interface SalesRepository {
    public List<SalesDto> findByMember(int memberId);
    public List<SalesDto> findSummaryByMenu();
    public List<SalesDto> findSummaryByMember();
}
