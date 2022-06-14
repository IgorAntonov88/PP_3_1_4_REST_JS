package com.example.pp_3_1_4_rest_js.controller;

import com.example.pp_3_1_4_rest_js.model.User;
import com.example.pp_3_1_4_rest_js.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserRestController {
    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> user(Principal principal) {
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
    }
}
