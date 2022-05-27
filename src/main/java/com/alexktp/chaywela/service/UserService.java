package com.alexktp.chaywela.service;

import com.alexktp.chaywela.model.User;

import java.util.Collection;

public interface UserService {

    User create(User user);
    User get(Long id);
    User update(User user);
    Boolean delete(Long id);
    Collection<User> getAll(int limit);


}
