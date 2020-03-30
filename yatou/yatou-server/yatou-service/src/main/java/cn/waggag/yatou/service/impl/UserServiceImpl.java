package cn.waggag.yatou.service.impl;

import cn.waggag.yatou.entity.User;
import cn.waggag.yatou.repository.UserRepository;
import cn.waggag.yatou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }

    @Override
    public void addUser(User user) {
        User existUser = userRepository.findByUsername(user.getUsername());
        if(existUser == null){
            user.setCreateData(new Date());
            user.setUpdateData(new Date());
            user.setEnabled(true);
            userRepository.save(user);
        }
    }
}
