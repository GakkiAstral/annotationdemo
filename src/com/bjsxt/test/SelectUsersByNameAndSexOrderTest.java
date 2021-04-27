package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectUsersByNameAndSexOrderTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        List<Users> list = usersMapper.selectUsersByNameAndSexOrder("oldlu","male");
        list.forEach(System.out::println);
    }
}
