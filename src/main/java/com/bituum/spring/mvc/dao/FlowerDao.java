package com.bituum.spring.mvc.dao;


import com.bituum.spring.mvc.models.Flower;
import com.bituum.spring.mvc.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FlowerDao {
    List<Flower> showAll();

    Flower showById(int id);

    void add(Flower flower);

    void delete(Flower flower);

    void update(Flower flower);
}
