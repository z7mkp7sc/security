package com.swift.taylor.mapper;

import com.swift.taylor.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: eewjnun
 * @date: Created in 2019/12/26 16:16
 * @version: v1
 * @modified By:
 */
@Mapper
public interface RoleMapper {

    @Select( "SELECT A.id,A.name FROM role A LEFT JOIN user_role B ON A.id=B.role_id WHERE B.user_id=${userId}" )
    List<Role> getRolesByUserId(@Param("userId") Long userId);

}
