package cn.waggag.yatou.service;

import cn.waggag.yatou.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService{

    List<User> listUser();

    public UserDetails loadUserByUsername(String username);

    void addUser(User user);
}
