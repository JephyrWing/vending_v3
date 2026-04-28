package repository;

import state.DrinkDto;
import state.SalesDto;
import state.SummaryDto;

import java.util.List;

public interface SalesRepository {
    List<SalesDto> findByMember(int memberId);
    List<SalesDto> findAll();
    List<DrinkDto> findSummaryByMenu();
    List<SummaryDto> findSummaryByMember();
    int sell(SalesDto dto);
}
