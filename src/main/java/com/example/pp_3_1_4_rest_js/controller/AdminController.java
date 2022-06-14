package com.example.pp_3_1_4_rest_js.controller;

import com.example.pp_3_1_4_rest_js.model.User;
import com.example.pp_3_1_4_rest_js.service.RoleService;
import com.example.pp_3_1_4_rest_js.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    @GetMapping()
    public String findAll(Principal principal, Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        model.addAttribute("person", new User());
        return "adminPage";
    }
    @PostMapping("/new")
    public String addUser(@ModelAttribute("person") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }
    @PatchMapping("/update/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }
}