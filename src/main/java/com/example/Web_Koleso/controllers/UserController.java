package com.example.Web_Koleso.controllers;

import com.example.Web_Koleso.servises.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Метод ShowLoginPage возвращает на страницу авторизации для доступа к панели администратора
     */

    @GetMapping("/autorization")
    public String ShowLoginPage() {
        return "autorization";
    }

    /**
     * Метод ShowLoginPage возвращает на страницу авторизации для доступа к панели администратора
     */

    @PostMapping("/autorization")
    public String Autentification (@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (userService.authenticate(username, password)) {
            // Успешная авторизация
            return "redirect:/upload"; // Переход на страницу приветствия
        } else {
            // Неправильный логин или пароль
            model.addAttribute("error", true);
            return "autorization"; // Вернуться на страницу входа
        }
    }

    @GetMapping("/upload")
    public String ShowUploadPage() {
        return "upload";
    }
}


