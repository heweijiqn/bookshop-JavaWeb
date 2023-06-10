package com.bookshop.dao.impl;

import com.bookshop.dao.UserDao;
import com.bookshop.pojo.User;

import java.util.List;

public class UserDaoImpl extends BasicDAO<User> implements UserDao {
    @Override
    public List<User> queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from user where username = ?";
        return queryMulti(sql, User.class, username);
    }

    @Override
    public List<User>queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from user where username = ? and password = ?";
        return queryMulti(sql, User.class, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql, user.getUsername(),user.getPassword(),user.getEmail());
    }
}
