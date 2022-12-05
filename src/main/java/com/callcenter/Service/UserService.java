package com.callcenter.Service;

import com.callcenter.Domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();
    User save(User user);
    void delete(User user);
    Optional<User> findUserById(String id);

}
