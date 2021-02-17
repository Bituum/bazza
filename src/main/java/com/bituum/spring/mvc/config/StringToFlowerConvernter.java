package com.bituum.spring.mvc.config;

import com.bituum.spring.mvc.dao.FlowerDaoImpl;
import com.bituum.spring.mvc.models.Flower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class StringToFlowerConvernter implements Converter<String, Flower> {
    @Autowired
    private FlowerDaoImpl repository;

    @Override
    public Flower convert(final String source) {
        return repository.showById(Integer.parseInt(source));
    }

}
