package qeqs.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import qeqs.entities.Finance;
import qeqs.entities.Type;

public interface FinanceMapper extends Mapper<Finance> {

    @Results({
        @Result(property = "id", column = "id")
        ,
          @Result(property = "value", column = "value")
        ,
          @Result(property = "date", column = "date")
        ,
          @Result(property = "description", column = "description")
        ,
          @Result(property = "financeType", column = "type", javaType = Type.class, one = @One(select = "SELECT * FROM type WHERE id = #{type}"))
    })
    @Select("SELECT * from finance WHERE id = #{id}")
    @Override
    Finance selectOne(int id);

    @Results({
        @Result(property = "id", column = "id")
        ,
          @Result(property = "value", column = "value")
        ,
          @Result(property = "date", column = "date")
        ,
          @Result(property = "description", column = "description")
        ,
          @Result(property = "financeType", column = "type", javaType = Type.class, one = @One(select = "SELECT * FROM type WHERE id = #{type}"))
    })
    @Select("SELECT * from finance")
    @Override
    List<Finance> selectAll();

    @Insert("INSERT into finance(value, date, description, type) VALUES(#{value}, #{date}, #{description}, #{type})")
    @Options(useGeneratedKeys = true, keyProperty = "id", flushCache = true, keyColumn = "id")
    @Override
    void insert(Finance finance);

    @Update("UPDATE finance SET value=#{value}, date=#{date}, description=#{description}, type=#{type} WHERE id =#{id}")
    @Override
    void update(Finance finance);

    @Delete("DELETE FROM finance WHERE id =#{id}")
    void delete(int id);

}
