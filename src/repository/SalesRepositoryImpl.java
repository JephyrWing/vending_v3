package repository;

import dto.SalesDto;
import state.VendingState;
import java.util.List;

public class SalesRepositoryImpl implements SalesRepository{
    private final VendingState state;

    public SalesRepositoryImpl(VendingState state) {
        this.state = state;
    }

    @Override
    public List<SalesDto> findByMember(int memberId) {
        return List.of();
    }

    @Override
    public List<SalesDto> findSummaryByMenu() {
        return List.of();
    }

    @Override
    public List<SalesDto> findSummaryByMember() {
        return List.of();
    }
}
