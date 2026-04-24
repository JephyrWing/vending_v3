package service;

import dto.SalesDto;
import repository.SalesRepository;

import java.util.List;

public class SalesServiceImpl implements SalesService {
    private final SalesRepository repository;

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
}
