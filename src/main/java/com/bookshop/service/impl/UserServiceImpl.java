package com.bookshop.service.impl;

import com.bookshop.dao.impl.UserDaoImpl;
import com.bookshop.pojo.User;
import com.bookshop.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
       if (userDao.queryUserByUsername(username) == null||userDao.queryUserByUsername(username).size() == 0) {
            return false;
       }
         return true;
    }
}
