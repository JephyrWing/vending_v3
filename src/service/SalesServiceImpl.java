package service;

import state.SalesDto;
import repository.SalesRepository;
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
        return List.of();
    }

    @Override
    public List<SalesDto> getSummaryByMenu() {
        return List.of();
    }

    @Override
    public List<SalesDto> getSummaryByMember() {
        return List.of();
    }

    @Override
    public int sell(int memberId, int menuId, int price) {
        SalesDto dto = new SalesDto(memberId, menuId, price, utilities.curtime());
        int result = repository.sell(dto);
        return result;
    }
}
