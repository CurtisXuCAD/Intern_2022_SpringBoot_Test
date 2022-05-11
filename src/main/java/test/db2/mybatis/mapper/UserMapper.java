package test.db2.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import test.db2.mybatis.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //通过用户名密码查询用户数据
    @Select("select * from customers where email = #{email,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR}")
    User getByUserNameAndPassword(User user);

    @Select("select * from customers Order by id desc limit 10")
    List<User> findLast10();
}
