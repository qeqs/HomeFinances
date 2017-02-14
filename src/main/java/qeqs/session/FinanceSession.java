package qeqs.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qeqs.entities.Finance;
import qeqs.mappers.FinanceMapper;
import qeqs.mappers.Mapper;

@Service("financeSession")
public class FinanceSession extends Session<Finance> {

    @Autowired
    private FinanceMapper mapper;

    @Override
    protected Mapper<Finance> getMapper() {
        return mapper;
    }
}
