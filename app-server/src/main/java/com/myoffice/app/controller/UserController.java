package com.myoffice.app.controller;

import com.myoffice.app.common.R;
import com.myoffice.app.model.request.UserRequest;
import com.myoffice.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/auth/user/login")
    public R userLogin(@RequestBody UserRequest userRequest) {
        return userService.login(userRequest);
    }

    @PostMapping("/api/admin/user/create")
    public R createUser(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping("/api/user/all")
    public R getAllUsers() {
        return userService.getAllUsers();
    }
}
