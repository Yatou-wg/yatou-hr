package cn.waggag.yatou.service.impl;

import cn.waggag.yatou.entity.User;
import cn.waggag.yatou.repository.UserRepository;
import cn.waggag.yatou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
}
