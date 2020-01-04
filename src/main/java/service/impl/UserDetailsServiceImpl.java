package service.impl;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

    public UserDetailsServiceImpl() {
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDao.getByEmail(email);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            logger.info("User wasn't found with email " + email);
            throw new UsernameNotFoundException("Such user wasn't found.");
        }
    }

}
