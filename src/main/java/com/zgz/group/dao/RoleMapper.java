package com.zgz.group.dao;

import com.base.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleMapper {


    List<Role> queryRoleListByUserName(String username);


    Set<String> queryRoleIdsByUsername(String username);

    Set<String> queryRoleListByUrls(@Param("urls") Set<String> urls);

}
