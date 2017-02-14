
package qeqs.session;

import java.util.List;
import javax.transaction.Transactional;
import qeqs.mappers.Mapper;


public abstract class Session<T> {
    
    protected abstract Mapper<T> getMapper();
    
    @Transactional
    public void save(T object) {
        getMapper().insert(object);
    }

    @Transactional
    public void update(T object) {
        getMapper().update(object);
    }

    @Transactional
    public void delete(Integer id) {
        getMapper().delete(id);
    }

    public T get(Integer id) {
        return getMapper().selectOne(id);
    }

    public List<T> getAll() {
        return getMapper().selectAll();
    }
}
