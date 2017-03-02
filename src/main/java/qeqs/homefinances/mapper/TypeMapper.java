package qeqs.homefinances.mapper;

import java.util.List;
import qeqs.homefinances.domain.Type;

public interface TypeMapper {

    Type selectOne(int id);

    void insert(Type type);

    void update(Type type);

    void delete(int id);

    List<Type> selectAll();


}
