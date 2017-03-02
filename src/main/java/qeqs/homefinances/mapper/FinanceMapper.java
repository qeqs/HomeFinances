package qeqs.homefinances.mapper;

import java.util.List;
import qeqs.homefinances.domain.Finance;

public interface FinanceMapper {

    Finance selectOne(int id);

    List<Finance> selectAll();

    void insert(Finance finance);

    void update(Finance finance);

    void delete(int id);

}
