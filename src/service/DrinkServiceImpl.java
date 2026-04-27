package service;

import state.DrinkDto;
import repository.DrinkRepository;

import java.util.List;

public class DrinkServiceImpl implements DrinkService {
    private final DrinkRepository repository;

    public DrinkServiceImpl(DrinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public int insert(String name, int price, int stock) {
        return 0;
    }

    @Override
    public int update(String name, int price, int stock) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<DrinkDto> getAll() {
        return List.of();
    }

    @Override
    public int sell(int memberId, int menuId) {
        return 0;
    }
}
