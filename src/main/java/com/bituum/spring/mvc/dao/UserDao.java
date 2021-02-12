package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserDao {
    public List<User> showAll();

    public User showById(int id);

    public void add(User user);

    public void delete(User user, int id);

    public void update(User user, int id);
}
