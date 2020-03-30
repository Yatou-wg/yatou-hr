package cn.waggag.yatou.repository;

import cn.waggag.yatou.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 用户
     */
    public User findByUsername(String username);

}
