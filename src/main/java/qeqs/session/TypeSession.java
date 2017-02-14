package qeqs.session;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import qeqs.entities.Type;
import qeqs.mappers.TypeMapper;

public class TypeSession {
    
    public void save(Type type) {
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            TypeMapper mapper = session.getMapper(TypeMapper.class);
            mapper.insert(type);
            
            session.commit();
        }
    }

    public void update(Type type) {
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            TypeMapper mapper = session.getMapper(TypeMapper.class);
            mapper.update(type);
            
            session.commit();
        }
    }

    public void delete(Integer id) {
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            TypeMapper mapper = session.getMapper(TypeMapper.class);
            mapper.delete(id);
            
            session.commit();
        }
    }

    public Type get(Integer id) {
        Type type;
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            TypeMapper mapper = session.getMapper(TypeMapper.class);
            type = mapper.selectOne(id);
        }
        return type;
    }
    public List<Type> getAll(){        
        List<Type> types;
        try (SqlSession session = SessionFactory.getSqlSessionFactory().openSession()) {
            TypeMapper mapper = session.getMapper(TypeMapper.class);
            types = mapper.selectAll();
        }
        return types;
    }
}
