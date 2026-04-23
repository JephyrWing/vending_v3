package service;

import repository.SalesRepository;

public class SalesServiceImpl implements SalesService {
    private final SalesRepository repository;

    public SalesServiceImpl(SalesRepository repository) {
        this.repository = repository;
    }
}
