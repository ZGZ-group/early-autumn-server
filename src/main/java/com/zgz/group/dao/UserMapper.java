package com.zgz.group.dao;

import com.zgz.group.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    User querByUserNameAndPassword(String username, String password);


}