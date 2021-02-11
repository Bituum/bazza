package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.User;

import java.util.List;

public interface UserDao {
    public List<User> showAll();

    public User showById();

    public void add(User user);

    public void delete(User user, int id);
}
