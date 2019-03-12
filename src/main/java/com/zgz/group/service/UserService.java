package com.zgz.group.service;

import com.zgz.group.domain.User;

public interface UserService {

    User querByUserNameAndPassword(String username, String password);

}
