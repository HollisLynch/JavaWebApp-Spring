package init;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import service.UserService;

@Component
public class DatabaseInitializer {

    private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public DatabaseInitializer(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public void init() {
        User admin = new User("admin12", "admin" ,"admin", "admin@gmail.com", "06/06/2000");
        User user = new User("user47", "user" ,"12345", "user@gmail.com", "07/06/2000");
        userService.addUser(user);
        userService.addUser(admin);
    }

}
