package service.impl;


import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import service.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user) {
        String securePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(securePassword);
        userDao.addUser(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    public Optional<User> getById(Long userId) {
        return userDao.getById(userId);
    }

    public void updateUser(User user) {
        String securePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(securePassword);
        userDao.updateUser(user);
    }

}
