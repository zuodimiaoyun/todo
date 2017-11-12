package club.wayto.todo.dao;

import club.wayto.todo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user (email, password, name) values (#{email}, #{password}, #{name})")
    public void insert(User user);
    @Select("select * from user where email = #{email}")
    public User getByEmail(String email);
    @Select("select * from user where name = #{name}")
    public User getByName(String name);
}
