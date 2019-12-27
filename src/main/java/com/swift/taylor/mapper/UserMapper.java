package com.swift.taylor.mapper;

import com.swift.taylor.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author: eewjnun
 * @date: Created in 2019/12/26 16:17
 * @version: v1
 * @modified By:
 */
@Mapper
public interface UserMapper {

    @Select( "select id , username , password from user where username = #{username}" )
    User loadUserByUsername(@Param("username") String username);

}
