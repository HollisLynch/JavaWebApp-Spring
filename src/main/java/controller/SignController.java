package controller;

import init.DatabaseInitializer;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import static java.util.Objects.nonNull;

@RestController
public class SignController {

    private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SignController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/sign")
    public String signIn(@AuthenticationPrincipal User user) {
        DatabaseInitializer db = new DatabaseInitializer(userService,passwordEncoder);
        db.init();

        if (userService.getAllUsers().isEmpty()) {
            DatabaseInitializer initializer = new DatabaseInitializer(userService, passwordEncoder);
            initializer.init();
        }
        return "index.jsp";
    }

    @GetMapping("/")
    public String signIn(@AuthenticationPrincipal User user,
                         Model model) {
        DatabaseInitializer db = new DatabaseInitializer(userService,passwordEncoder);
        db.init();

        if (nonNull(user)) {
            if (user.getRole().equals("ROLE_ADMIN")) {
                return "redirect:/admin/users";
            } else {
                return "redirect:/user/products";
            }
        } else {
            model.addAttribute("unknown", "The user is not found. Try again. ");
            return "index.jsp";
        }
    }

}
