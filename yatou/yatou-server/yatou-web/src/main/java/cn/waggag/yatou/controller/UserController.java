package cn.waggag.yatou.controller;

import cn.waggag.yatou.entity.User;
import cn.waggag.yatou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<User>> listUser(
            @RequestParam(defaultValue = "0") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            String username) {
        Page<User> userPage = userService.listUser(pageNum, pageSize, username);
        return ResponseEntity.ok(userPage);
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user){
        //用户密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/updatePwd")
    public ResponseEntity<HttpStatus> updatePwd(@RequestParam String oldPassword, @RequestParam String newPassword){
        System.out.println(oldPassword+newPassword);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
