package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectUsersByPropertyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        //不写set的时候,就相当于查询所有用户信息
        users.setUsername("oldlu");
        List<Users> list = usersMapper.selectUsersByProperty(users);
        list.forEach(System.out::println);
    }
}
