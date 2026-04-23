package service;

import repository.DrinkRepository;

public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository repository;

    public DrinkServiceImpl(DrinkRepository repository) {
        this.repository = repository;
    }
}
