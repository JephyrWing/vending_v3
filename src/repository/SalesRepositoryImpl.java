package repository;

import state.MemberDto;
import state.SalesDto;
import state.VendingState;

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
    public List<SalesDto> findSummaryByMenu() {
        return List.of();
    }

    @Override
    public List<SalesDto> findSummaryByMember() {
        return List.of();
    }

    @Override
    public int sell(SalesDto dto) {
        int result = state.insertData(dto);
        return result;
    }
}
