package repository;

import state.*;

import java.util.ArrayList;
import java.util.List;

public class SalesRepositoryImpl implements SalesRepository{
    private final VendingState state;

    public SalesRepositoryImpl(VendingState state) {
        this.state = state;
    }

    @Override
    public List<SalesDto> findByMember(int memberId) {
        List<SalesDto> list = state.selectSales();
        List<SalesDto> result = new ArrayList<>();
        for (SalesDto i : list) {
            if (i.getMemberId() == memberId) {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public List<SalesDto> findAll() {
        return state.selectSales();
    }

    @Override
    public List<DrinkDto> findSummaryByMenu() {
        return state.selectSalesSummaryByMenu();
    }

    @Override
    public List<SummaryDto> findSummaryByMember() {
        return state.selectSalesSummaryByMember();
    }


    @Override
    public int sell(SalesDto dto) {
        int result = state.insertData(dto);
        return result;
    }
}
