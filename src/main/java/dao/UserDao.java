package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    List<User> getAllUsers();

    void deleteUser(User user);

    Optional<User> getByEmail(String email);

    Optional<User> getById(Long userId);

    void updateUser(User user);
}
