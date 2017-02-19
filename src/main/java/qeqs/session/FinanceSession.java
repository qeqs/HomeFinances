package qeqs.session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qeqs.entities.Finance;
import qeqs.mappers.FinanceMapper;
import qeqs.mappers.Mapper;

@Service("financeSession")
public class FinanceSession extends Session<Finance> {

    @Autowired
    private SqlSession sqlSession;

    @Override
    protected Mapper<Finance> getMapper() {
        return sqlSession.getMapper(FinanceMapper.class);
    }
}
