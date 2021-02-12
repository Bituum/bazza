package com.bituum.spring.mvc.dao;


import com.bituum.spring.mvc.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlowerDao {
    List<User> showAll();

    User showById(int id);

    void add(User user);

    void delete(User user);

    void update(User user);
}
