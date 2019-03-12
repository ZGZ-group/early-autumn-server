package com.zgz.group.service.impl;

import com.zgz.group.dao.RoleResourceMapper;
import com.zgz.group.domain.RoleResource;
import com.zgz.group.service.RoleResourceService;
import com.zgz.group.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    private RoleResourceMapper roleResourceMapper;

    @Override
    public List<RoleResource> getRoleResourceByResourceIds(Set<String> resourceIds) {

        if (CollectionUtil.isEmpty(resourceIds)) {
            return Collections.emptyList();
        }

        return roleResourceMapper.queryRoleResourceByResourceIds(resourceIds);
    }

    @Autowired
    public void setRoleResourceMapper(RoleResourceMapper roleResourceMapper) {
        this.roleResourceMapper = roleResourceMapper;
    }
}
