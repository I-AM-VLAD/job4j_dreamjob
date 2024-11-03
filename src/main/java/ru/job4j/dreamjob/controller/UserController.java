package ru.job4j.dreamjob.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.service.UserService;

@ThreadSafe
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register/{email}/{password}")
    public String getRegistrationPage(Model model, @PathVariable String email, @PathVariable String password) {
        var userOptional = userService.findByEmailAndPassword(email, password);
        if (userOptional.isEmpty()) {
            model.addAttribute("message", "Пользователя с такой почтой и паролем не существует");
            return "errors/404";
        }
        return "redirect:/vacancies";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute User user) {
        var savedUser = userService.save(user);
        if (savedUser.isEmpty()) {
            model.addAttribute("message", "Пользователь с такой почтой уже существует");
            return "errors/404";
        }
        return "redirect:/vacancies";
    }
}
