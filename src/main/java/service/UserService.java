package service;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    void deleteUser(User user);

    Optional<User> getById(Long userId);

    void updateUser(User user);
}
