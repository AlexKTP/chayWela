package com.alexktp.chaywela.service;

import com.alexktp.chaywela.model.User;

public interface UserService {

    User create(User user);
    User get(Long id);
    User update(User user);
    Boolean delete(Long id);

}
