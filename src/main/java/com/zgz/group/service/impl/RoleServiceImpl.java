package com.zgz.group.service.impl;

import com.zgz.group.dao.RoleMapper;
import com.zgz.group.domain.Role;
import com.zgz.group.service.RoleService;
import com.zgz.group.util.CollectionUtil;
import com.zgz.group.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    //角色入库时需要加上前缀,否则SpringSecurity无法识别
    private static final String ROLE_PERFIX = "ROLE_";

    private RoleMapper roleMapper;

    @Override
    public Set<String> getRoleSetByUrls(Set<String> urls) {
        if (CollectionUtil.isEmpty(urls)) {
            return Collections.emptySet();
        }
        return roleMapper.queryRoleListByUrls(urls);
    }

    @Override
    public Set<String> getRoleIdsByUserName(String username) {
        return roleMapper.queryRoleIdsByUsername(username);
    }

    @Override
    public List<Role> getRoleListByUserName(String username) {

        if (StringUtil.isEmpty(username)) {
            return Collections.emptyList();
        }

        return roleMapper.queryRoleListByUserName(username);
    }

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }
}
