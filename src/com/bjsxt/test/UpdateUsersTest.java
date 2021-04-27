package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UpdateUsersTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("itbz-sxt1");
        users.setUsersex("male");
        users.setUserid(6);
        int flag = usersMapper.updateUsers(users);
        sqlSession.commit();
        System.out.println(flag);
    }
}
