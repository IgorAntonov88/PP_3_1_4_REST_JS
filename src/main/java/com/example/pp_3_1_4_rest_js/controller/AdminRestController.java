package com.example.pp_3_1_4_rest_js.controller;

import com.example.pp_3_1_4_rest_js.exception.NotFoundUserException;
import com.example.pp_3_1_4_rest_js.model.User;
import com.example.pp_3_1_4_rest_js.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminRestController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> findAllUsers () {
        return (ResponseEntity<List<User>>) ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/{id}")
    public User findUser (@PathVariable Long id) {
        User user = userService.findById(id);
        if(user==null) {
            throw new NotFoundUserException("Not found this User with ID = " + id + " in DataBase");
        }
        return user;
    }
    @PostMapping()
    public User addNewUser (@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }
    @PutMapping()
    public User updateUser (@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }
    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable Long id) {
        User user = userService.findById(id);
        if(user==null) {
            throw new NotFoundUserException("Not found this User with ID = " + id + " in DataBase");
        }
        userService.deleteById(id);
        return "User with ID = " + id + " was deleted from DataBase";
    }


}
