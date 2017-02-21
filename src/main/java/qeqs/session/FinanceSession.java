package qeqs.session;

import org.springframework.stereotype.Service;
import qeqs.entities.Finance;
import qeqs.mappers.FinanceMapper;
import qeqs.mappers.Mapper;

@Service("financeSession")
public class FinanceSession extends Session<Finance> {


    @Override
    protected Mapper<Finance> getMapper() {
        return ctx.getBean(FinanceMapper.class);
    }
}
