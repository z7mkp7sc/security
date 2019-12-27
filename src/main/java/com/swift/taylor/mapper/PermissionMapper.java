package com.swift.taylor.mapper;

import com.swift.taylor.domain.RolePermisson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: eewjnun
 * @date: Created in 2019/12/26 16:11
 * @version:
 * @modified By:
 */
@Mapper
public interface PermissionMapper {
    @Select( "SELECT A.NAME AS roleName,C.url FROM role AS A LEFT JOIN role_permission B ON A.id=B.role_id LEFT JOIN permission AS C ON B.permission_id=C.id" )
    List<RolePermisson> getRolePermissions();

}
