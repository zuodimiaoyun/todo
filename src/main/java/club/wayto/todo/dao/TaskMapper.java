package club.wayto.todo.dao;
import club.wayto.todo.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskMapper {

    @Select("select * from task where userId=#{userId}")
    public List<Task> getByUser(@Param("userId") Long userId);
    @Select("select * from task where user_id=#{userId} and status=#{status}")
    public List<Task> getByUserAndStatus(@Param("userId") Long userId, @Param("status") Integer status);
}
