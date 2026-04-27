package repository;

import state.DrinkDto;
import state.MemberDto;
import state.VendingState;

import java.util.ArrayList;
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
        return state.updateData(dto);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<DrinkDto> findAll() {
        return state.selectVendingMenu();
    }

    @Override
    public List<DrinkDto> findById(int id) {
        List<DrinkDto> list = state.selectVendingMenu();
        List<DrinkDto> result = new ArrayList<>();
        for (DrinkDto i : list) {
            if (i.getId() == id) {
                result.add(i);
            }
        }
        return result;
    }

}
