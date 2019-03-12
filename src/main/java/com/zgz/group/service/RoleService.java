package com.zgz.group.service;

import com.zgz.group.domain.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {


    List<Role> getRoleListByUserName(String username);

    Set<String> getRoleIdsByUserName(String username);

    Set<String> getRoleSetByUrls(Set<String> urls);
}
