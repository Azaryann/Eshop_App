package am.azaryan.service;

import am.azaryan.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);

    User register(User user);

    List<User> findAll();

    Optional<User> findByEmail(String email);

}
