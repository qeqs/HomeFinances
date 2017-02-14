
package qeqs.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import qeqs.entities.Finance;

public interface FinanceMapper {
    @Results({
          @Result(property = "id", column = "id"),
          @Result(property = "value", column = "value"),
          @Result(property = "date", column = "date"),
          @Result(property = "description", column = "description"),
          @Result(property = "type", column = "type", one = @One(select = "SELECT id,name FROM type WHERE id = #{type}"))
        })
	@Select("SELECT id, value, date, description, type from finance WHERE id = #{id}")
	Finance selectOne(int id);
        
	@Select("SELECT id, value, date, description, type from finance")
        List<Finance> selectAll();
	
	@Insert("INSERT into finance(value, date, description, type) VALUES(#{value}, #{date}, #{description}, #{type})")
	void insert(Finance finance);
	
	@Update("UPDATE finance SET value=#{value}, date=#{date}, description=#{description}, type=#{type} WHERE id =#{id}")
	void update(Finance finance);
	
	@Delete("DELETE FROM finance WHERE id =#{id}")
	void delete(int id);
        
}
