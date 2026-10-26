package ru.job4j.dreamjob.controller;
/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.ui.ConcurrentModel;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.service.UserService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserControllerTest {

    private UserService userService;

    private UserController userController;

    @BeforeEach
    public void initService() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    public void whenTestGetRegistrationPage() {
        var model = new ConcurrentModel();
        assertThat(userController.getRegistrationPage(model)).isEqualTo("users/register");
    }

    @Test
    public void whenTestRegister() {
        var user = new User(1, "vlad@gmail.com", "Vlad", "12345");
        when(userService.save(any(User.class))).thenReturn(Optional.of(user));

        var model = new ConcurrentModel();
        var view = userController.register(model, user);

        assertThat(view).isEqualTo("redirect:/vacancies");
    }

    @Test
    public void whenTestGetLoginPage() {
        var model = new ConcurrentModel();
        assertThat(userController.getLoginPage(model)).isEqualTo("users/login");
    }

    @Test
    public void whenTestLoginUser() {
        var user = new User(1, "vlad@gmail.com", "Vlad", "12345");
        when(userService.findByEmailAndPassword(any(String.class), any(String.class))).thenReturn(Optional.of(user));

        var model = new ConcurrentModel();
        var view = userController.loginUser(user, model,);
        var actualVacancy = model.getAttribute("vacancy");

    }
}
 */