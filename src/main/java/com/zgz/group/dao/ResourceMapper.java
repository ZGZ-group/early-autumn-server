package com.zgz.group.dao;

import com.zgz.group.domain.Resource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceMapper {

    List<Resource> queryAllResource();

}
