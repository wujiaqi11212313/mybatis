package dao;

import po.User;

import java.util.List;

public interface UserDao {
    //根据id查询用户信息
    public User findUserById(int id);
    public List<User> findUserByName(String name);
}
