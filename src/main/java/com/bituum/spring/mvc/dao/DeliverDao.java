package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.Deliver;
import com.bituum.spring.mvc.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeliverDao {
    List<Deliver> showAll();

    Deliver showById(int id);

    void add(Deliver deliver);

    void delete(Deliver deliver);

    void update(Deliver deliver);
}
