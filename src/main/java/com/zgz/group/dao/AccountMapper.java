package com.zgz.group.dao;

import com.zgz.group.domain.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {


    Account queryByUserName(String username);

    int addAccount(Account account);

}
