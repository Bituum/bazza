package com.bituum.spring.mvc.controllers;

import com.bituum.spring.mvc.dao.CompositionDao;
import com.bituum.spring.mvc.dao.CompositionDaoImpl;
import com.bituum.spring.mvc.dao.FlowerDaoImpl;
import com.bituum.spring.mvc.models.Composition;
import com.bituum.spring.mvc.models.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.thymeleaf.util.StringUtils;

import java.beans.PropertyEditorSupport;

@Controller
public class FlowerCompositionController {


    @InitBinder(value = "flowerList")
    protected void initBinder(final WebDataBinder binder){
        binder.registerCustomEditor(Flower.class, new CompositionPropertyEditor());
    }
    private static class CompositionPropertyEditor extends PropertyEditorSupport{
        @Autowired
        private FlowerDaoImpl flowerDao;

        @Override
        public String getAsText() {
            Flower flower = (Flower) getValue();
            if(flower == null){
                return null;
            }
            return String.valueOf(flower.getId());
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(flowerDao.showById(Integer.parseInt(text)));

        }
    }
}
