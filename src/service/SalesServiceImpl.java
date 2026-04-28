package service;

import state.DrinkDto;
import state.SalesDto;
import repository.SalesRepository;
import state.SummaryDto;
import utilities.Utilities;

import java.util.List;

public class SalesServiceImpl implements SalesService {
    private final SalesRepository repository;
    Utilities utilities = new Utilities();

    public SalesServiceImpl(SalesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SalesDto> getByMember(int memberId) {
        return repository.findByMember(memberId);
    }

    @Override
    public List<DrinkDto> getSummaryByMenu() {
        return repository.findSummaryByMenu();
    }

    @Override
    public List<SummaryDto> getSummaryByMember() {
        return repository.findSummaryByMember();
    }

    @Override
    public int sell(int memberId, int menuId, int price) {
        SalesDto dto = new SalesDto(memberId, menuId, price, utilities.curtime());
        int result = repository.sell(dto);
        return result;
    }
}
