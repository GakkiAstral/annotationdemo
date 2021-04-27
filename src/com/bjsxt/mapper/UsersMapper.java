package com.bjsxt.mapper;

import com.bjsxt.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UsersMapper {
    //无参,查询所有用户
    @Select("select * from users")
    List<Users> selectUsersAll();

    //基于顺序传参,根据用户的姓名和性别查询用户,写param,不写username等代号
    @Select("select * from users where username = #{param1} and usersex = #{param2}")
    List<Users> selectUsersByNameAndSexOrder(String username,String usersex);

    //基于顺序传参,根据用户的姓名和性别查询用户,不写Param,而使用代号
    @Select("select * from users where username = #{name} and usersex = #{sex}")
    List<Users> selectUsersByNameAndSexOrder2(@Param("name") String username, @Param("sex") String usersex);

    //基于POJO传参,根据用户的姓名和性别查询用户
    @Select("select * from users where username = #{username} and usersex = #{usersex}")
    List<Users> selectUsersByNameAndSexPOJO(Users users);

    //基于Map传参,根据用户的姓名和性别查询用户
    @Select("select * from users where username = #{keyname} and usersex = #{keysex}")
    List<Users> selectUsersByNameAndSexMap(Map<String,String> map);

    //完成添加用户的操作
    @Insert("insert into users values(default,#{username},#{usersex})")
    int insertUsers(Users users);

    //完成更新用户的操作
    @Update("update users set username = #{username},usersex = #{usersex} where userid = #{userid}")
    int updateUsers(Users users);

    //完成删除用户的操作
    @Delete("delete from users where userid = #{userid}")
    int deleteUsersById(int userid);

    //基于<script>标签完成动态SQL拼接。高级查询,无条件时查询所有用户,有条件时,根据条件查询
    @Select("<script>select * from users where 1 = 1 <if test = \"username != null and username != ''\"> and username = #{username}</if> <if test=\"usersex != null and usersex != ''\"> and usersex = #{usersex}</if></script>")
    List<Users> selectUsersByProperty(Users users);

    //基于MyBatis3注解中包含的@SelectProvider功能。高级查询,无条件时查询所有用户,有条件时,根据条件查询
    @SelectProvider(type = UsersMapperProvider.class,method = "selectUsersByPropertySQL")
    List<Users> selectUsersByPropertyProvider(Users users);
    class UsersMapperProvider{
        /**
         * 生成动态SQL
         */
        public String selectUsersByPropertySQL(Users users){
            StringBuffer stringBuffer = new StringBuffer("select * from users where 1=1");
            if (users.getUsername() != null && users.getUsername() != ""){
                stringBuffer.append(" and username = #{username}");
            }
            if (users.getUsersex() != null && users.getUsersex() != ""){
                stringBuffer.append(" and usersex = #{usersex}");
            }
            return stringBuffer.toString();
        }
    }

    //使用映射配置文件的方式实现对结果集的映射
    @Select("select userid as id,username as name,usersex as sex from users where userid = #{userid}")
    @Results(id = "usersMapper",value = {
            //property针对对象属性,column针对于结果集列名,最后一个Result是不需要加逗号的
            @Result(id = true,property = "userid",column = "id"),
            @Result(property = "username",column = "name"),
            @Result(property = "usersex",column = "sex")
    })
    Users selectUsersByIdMapper(int userid);

    //功能同上,复用usersMapper的Results注解
    @Select("select userid as id,username as name,usersex as sex from users where userid = #{userid}")
    @ResultMap(value = {"usersMapper"})
    Users selectUsersByIdMapper2(int userid);
}
