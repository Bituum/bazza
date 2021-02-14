package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.Composition;
import com.bituum.spring.mvc.models.Contract;
import com.bituum.spring.mvc.models.Deliver;

import java.util.List;

public interface ContractDao {
    List<Contract> showAll();

    Contract showById(int id);

    void add(Contract contract);

    void delete(Contract contract);

    void update(Contract contract);
}
