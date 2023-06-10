package com.bookshop.dao.impl;

import com.bookshop.dao.UserDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("admin"));

    }

    @Test
    void queryUserByUsernameAndPassword() {
        userDao.queryUserByUsernameAndPassword("admin","admin");
    }

    @Test
    void saveUser() {
        userDao.saveUser(null);
    }
}