package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Roles;
import com.bjsxt.pojo.Users;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class SelectUsersAndRolesByUserIdTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = usersMapper.selectUsersAndRolesByUserId(1);
        System.out.println(users);
        Roles roles = users.getRoles();
        System.out.println(roles);
    }
}
