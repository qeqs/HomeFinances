package qeqs.homefinances.service;

import java.util.List;
import qeqs.homefinances.domain.Finance;
import qeqs.homefinances.mapper.FinanceMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service("financeSession")
public class FinanceService {

    private FinanceMapper financeMapper;

    @Transactional
    public void save(Finance object) {
        financeMapper.insert(object);
    }

    @Transactional
    public void update(Finance object) {
        financeMapper.update(object);
    }

    @Transactional
    public void delete(Integer id) {
        financeMapper.delete(id);
    }

    public Finance get(Integer id) {
        return financeMapper.selectOne(id);
    }

    public List<Finance> getAll() {
        return financeMapper.selectAll();
    }

    public FinanceMapper getFinanceMapper() {
        return financeMapper;
    }

    public void setFinanceMapper(FinanceMapper financeMapper) {
        this.financeMapper = financeMapper;
    }

}
