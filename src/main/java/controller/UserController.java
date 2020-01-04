package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import java.util.Optional;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("admin/users")
public class UserController {

    private UserService userService;

    @Autowired
    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody User user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "add_user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user,
                          Model model) {
        try {
            userService.addUser(user);
            return "redirect:/admin/users";
        } catch (NumberFormatException ex) {
            model.addAttribute("validFields", "It isn't rightly. Enter the correct values.");
            return "add_user";
        }
    }

    @GetMapping("/add")
    public ModelAndView viewAddUserPage() {
        return new ModelAndView("add_user", "user", new User());
    }

    @ModelAttribute
    @PostMapping("/update")
    public String updateUser(@AuthenticationPrincipal User user,
                             Model model) {
        try {
            userService.updateUser(user);
            return "redirect:/admin/users";
        } catch (NumberFormatException ex) {
            model.addAttribute("validValues", "Something is wrong. Try again. ");
            return "edit_user";
        }
    }

    @GetMapping("/update")
    public ModelAndView updateUser(@RequestParam("id") Long id,
                                   Model model) {
        if (nonNull(id)) {
            Optional<User> optUser = userService.getById(id);
            model.addAttribute("id", id);
            if (optUser.isPresent()) {
                User user = optUser.get();
                model.addAttribute("user", user);
                return new ModelAndView("edit_user", "user", user);
            }
        }
        return new ModelAndView("edit_user");
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        if (nonNull(id)) {
            Optional<User> optUser = userService.getById(id);
            optUser.ifPresent(userService::deleteUser);
        }
        return "redirect:/admin/users";
    }

}
