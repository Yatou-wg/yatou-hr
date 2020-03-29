package cn.waggag.yatou.controller;

import cn.waggag.yatou.entity.User;
import cn.waggag.yatou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("list")
    public ResponseEntity<List<User>> listUser() {
        List<User> userList = userService.listUser();
        return ResponseEntity.ok(userList);
    }

}
