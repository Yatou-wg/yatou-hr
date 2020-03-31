package cn.waggag.yatou.service;

import cn.waggag.yatou.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService{

    UserDetails loadUserByUsername(String username);

    User findUserById(Integer id);

    Page<User> listUser(Integer pageNum, Integer pageSize, String username);

    void addUser(User user);
}
