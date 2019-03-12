package com.zgz.group.service;

import com.base.domain.User;

public interface UserService {

    User querByUserNameAndPassword(String username, String password);

}
