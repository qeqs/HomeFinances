package qeqs.session;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qeqs.entities.Type;
import qeqs.mappers.Mapper;
import qeqs.mappers.TypeMapper;

@Service("typeSession")
public class TypeSession extends Session<Type> {

    @Autowired
    private SqlSession sqlSession;

    @Override
    protected Mapper<Type> getMapper() {
        return sqlSession.getMapper(TypeMapper.class);
    }
}
