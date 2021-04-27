package com.bjsxt.test;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectUsersByNameAndSexMapTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
        Map<String,String> map = new HashMap<>();
        map.put("keyname","oldlu");
        map.put("keysex","male");
        List<Users> list = usersMapper.selectUsersByNameAndSexMap(map);
        list.forEach(System.out::println);
    }
}
