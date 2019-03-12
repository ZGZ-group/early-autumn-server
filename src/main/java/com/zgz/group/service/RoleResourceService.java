package com.zgz.group.service;

import com.zgz.group.domain.RoleResource;

import java.util.List;
import java.util.Set;

public interface RoleResourceService {

    List<RoleResource> getRoleResourceByResourceIds(Set<String> resourceIds);

}
