package qeqs.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qeqs.entities.Type;
import qeqs.mappers.Mapper;
import qeqs.mappers.TypeMapper;

@Service("typeSession")
public class TypeSession extends Session<Type> {

    @Autowired
    private TypeMapper mapper;

    @Override
    protected Mapper<Type> getMapper() {
        return mapper;
    }
}
