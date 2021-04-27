package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class SelectUsersByIdMapper2Test {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Users users = usersMapper.selectUsersByIdMapper2(1);
        System.out.println(users);
    }
}
