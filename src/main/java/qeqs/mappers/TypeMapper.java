package qeqs.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import qeqs.entities.Type;

public interface TypeMapper extends Mapper<Type>{

    @Results({
        @Result(property = "id", column = "id")
        ,
          @Result(property = "name", column = "name")
        ,
          @Result(property = "financeList", javaType = List.class, many = @Many(select = "SELECT id, value, date, description, type FROM finance WHERE type = #{id}"))
    })
    @Select("SELECT id, name FROM type WHERE id = #{id}")
    @Override
    Type selectOne(int id);

    @Insert("INSERT into type(name) VALUES(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", flushCache = true, keyColumn = "id")
    @Override
    void insert(Type type);

    @Update("UPDATE type SET name=#{name} WHERE id =#{id}")
    @Override
    void update(Type type);

    @Delete("DELETE FROM type WHERE id =#{id}")
    void delete(int id);

    @Select("SELECT id, name FROM type")
    @Override
    List<Type> selectAll();
}
