package cn.waggag.yatou.service.impl;

import cn.waggag.yatou.entity.User;
import cn.waggag.yatou.repository.UserRepository;
import cn.waggag.yatou.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.security.auth.login.AccountNotFoundException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public User findUserById(Integer id) {
        if(id != null){
            Optional<User> optionalUser = userRepository.findById(id);
            if(optionalUser.isPresent()){
                return optionalUser.get();
            }
        }
        return null;
    }

    @Override
    public Page<User> listUser(Integer pageNum, Integer pageSize, String username) {
        Specification<User> specification =  (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new LinkedList<>();
            if(StringUtils.isNotBlank(username)){
                predicates.add(criteriaBuilder.like(root.get("username"),username+"%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        return userRepository.findAll(specification, pageRequest);
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
