package qeqs.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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
          @Result(property = "financeList", javaType = List.class,column = "type = id", 
                  many = @Many(select = "SELECT * FROM finance WHERE type = #{type}"))
    })
    @Select("SELECT id, name FROM type WHERE id = #{id}")
    @Override
    Type selectOne(@Param("id")int id);
    
    @Results({
        @Result(property = "id", column = "id")
        ,
          @Result(property = "name", column = "name")
        ,
          @Result(property = "financeList", javaType = List.class,column = "type = id", 
                  many = @Many(select = "SELECT * FROM finance WHERE type = #{type}"))
    })
    @Insert("INSERT into type(name) VALUES(#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", flushCache = true, keyColumn = "id")
    @Override
    void insert(Type type);
    
    @Results({
        @Result(property = "id", column = "id")
        ,
          @Result(property = "name", column = "name")
        ,
          @Result(property = "financeList", javaType = List.class,column = "type = id", 
                  many = @Many(select = "SELECT * FROM finance WHERE type = #{type}"))
    })
    @Update("UPDATE type SET name=#{name} WHERE id =#{id}")
    @Override
    void update(Type type);
    
    @Results({
        @Result(property = "id", column = "id")
        ,
          @Result(property = "name", column = "name")
        ,
          @Result(property = "financeList", javaType = List.class,column = "type = id", 
                  many = @Many(select = "SELECT * FROM finance WHERE type = #{type}"))
    })
    @Delete("DELETE FROM type WHERE id =#{id}")
    void delete(int id);

    @Results({
        @Result(property = "id", column = "id")
        ,
          @Result(property = "name", column = "name")
        ,
          @Result(property = "financeList", javaType = List.class,column = "type = id", 
                  many = @Many(select = "SELECT * FROM finance WHERE type = #{type}"))
    })
    @Select("SELECT id, name FROM type")
    @Override
    List<Type> selectAll();
}
