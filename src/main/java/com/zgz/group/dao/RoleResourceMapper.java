package com.zgz.group.dao;

import com.zgz.group.domain.RoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleResourceMapper {

    List<RoleResource> queryRoleResourceByResourceIds(@Param("resourceIds") Set<String> resourceIds);

}
