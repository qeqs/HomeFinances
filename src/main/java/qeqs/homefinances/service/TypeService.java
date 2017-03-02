package qeqs.homefinances.service;

import java.util.List;
import qeqs.homefinances.domain.Type;
import qeqs.homefinances.mapper.TypeMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service("typeSession")
public class TypeService {

    private TypeMapper typeMapper;

    public TypeMapper getTypeMapper() {
        return typeMapper;
    }

    public void setTypeMapper(TypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    @Transactional
    public void save(Type object) {
        typeMapper.insert(object);
    }

    @Transactional
    public void update(Type object) {
        typeMapper.update(object);
    }

    @Transactional
    public void delete(Integer id) {
        typeMapper.delete(id);
    }

    public Type get(Integer id) {
        return typeMapper.selectOne(id);
    }

    public List<Type> getAll() {
        return typeMapper.selectAll();
    }

}
