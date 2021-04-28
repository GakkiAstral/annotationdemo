package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Orders;
import com.bjsxt.pojo.Users;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SelectUsersAndOrdersByUserIdTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = usersMapper.selectUsersAndOrdersByUserId(1);
        System.out.println(users);
        List<Orders> list = users.getOrders();
        list.forEach(System.out::println);
    }
}
