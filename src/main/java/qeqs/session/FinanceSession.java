package qeqs.session;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import qeqs.entities.Finance;
import qeqs.mappers.FinanceMapper;


public class FinanceSession {

    public void save(Finance finance) {
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            FinanceMapper mapper = session.getMapper(FinanceMapper.class);
            mapper.insert(finance);
            
            session.commit();
        }
    }

    public void update(Finance finance) {
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            FinanceMapper mapper = session.getMapper(FinanceMapper.class);
            mapper.update(finance);
            
            session.commit();
        }
    }

    public void delete(Integer id) {
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            FinanceMapper mapper = session.getMapper(FinanceMapper.class);
            mapper.delete(id);
            
            session.commit();
        }
    }

    public Finance get(Integer id) {
        Finance finance;
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            FinanceMapper mapper = session.getMapper(FinanceMapper.class);
            finance = mapper.selectOne(id);
        }
        return finance;
    }
    public List<Finance> getAll(){        
        List<Finance> finances;
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            FinanceMapper mapper = session.getMapper(FinanceMapper.class);
            finances = mapper.selectAll();
        }
        return finances;
    }
}
