package qeqs.session;

import org.springframework.stereotype.Service;
import qeqs.entities.Type;
import qeqs.mappers.Mapper;
import qeqs.mappers.TypeMapper;

@Service("typeSession")
public class TypeSession extends Session<Type> {


    @Override
    protected Mapper<Type> getMapper() {
        return ctx.getBean(TypeMapper.class);
    }
}
