package repository;

import dto.DrinkDto;
import state.VendingState;

import java.util.List;

public class DrinkRepositoryImpl implements DrinkRepository{
    private final VendingState state;

    public DrinkRepositoryImpl(VendingState state) {
        this.state = state;
    }

    @Override
    public int insert(DrinkDto dto) {
        return 0;
    }

    @Override
    public int update(DrinkDto dto) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<DrinkDto> findAll() {
        return List.of();
    }

    @Override
    public int sell(int memberId, int menuId) {
        return 0;
    }
}
