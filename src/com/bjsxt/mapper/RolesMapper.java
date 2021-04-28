package com.bjsxt.mapper;

import com.bjsxt.pojo.Roles;
import org.apache.ibatis.annotations.Select;

public interface RolesMapper {
    @Select("select * from roles where user_id = #{userid}")
    Roles selectRolesByUsersId(int userid);
}
