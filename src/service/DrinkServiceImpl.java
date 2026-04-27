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
    public int update(int id, String name, int price, int stock) {
        DrinkDto dto = new DrinkDto(id, name, price, stock);
        return repository.update(dto);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<DrinkDto> getAll() {
        return repository.findAll();
    }

    @Override
    public DrinkDto getById(int id) {
        DrinkDto result = null;
        List<DrinkDto> list = repository.findById(id);
        result = list.get(0);

        return result;
    }

    @Override
    public int[] getIds() {
        List<DrinkDto> list = getAll();
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).getId();
        }
        return result;
    }
}
