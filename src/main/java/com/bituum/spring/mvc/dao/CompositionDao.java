package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.Composition;
import com.bituum.spring.mvc.models.Deliver;

import java.util.List;

public interface CompositionDao {
    List<Composition> showAll();

    Composition showById(int id);

    void add(Composition composition);

    void delete(Composition composition);

    void update(Composition composition);
}