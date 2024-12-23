package am.azaryan.service;

import am.azaryan.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User register(User user);

    List<User> findAll();

    User findByEmail(String email);

}
