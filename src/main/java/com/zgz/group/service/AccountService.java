package com.zgz.group.service;

import com.base.domain.Account;

public interface AccountService {
    Account getAccountByUserName(String username);

    int register(String username, String password);
}
