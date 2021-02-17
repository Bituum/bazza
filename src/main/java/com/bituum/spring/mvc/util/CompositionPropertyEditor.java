package com.bituum.spring.mvc.util;

import com.bituum.spring.mvc.dao.FlowerDaoImpl;

import com.bituum.spring.mvc.models.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompositionPropertyEditor implements Converter<String, Flower> {
    private final FlowerDaoImpl repository;

    public CompositionPropertyEditor(FlowerDaoImpl repository) {
        this.repository = repository;
    }

    @Override
    public Flower convert(final String source) {
        return repository.showById(Integer.parseInt(source));

    }
}
