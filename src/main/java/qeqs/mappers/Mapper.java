
package qeqs.mappers;

import java.util.List;


public interface Mapper<T> {
    void insert(T object);
    void update(T object);
    void delete(Integer id);
    T selectOne(int id);
    List<T> selectAll();
}
