package com.bituum.spring.mvc.dao;

import com.bituum.spring.mvc.models.Flower;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
@Repository
public class FlowerDTO {
    private List<Flower> flowerList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerDTO flowerDTO = (FlowerDTO) o;
        return Objects.equals(flowerList, flowerDTO.flowerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowerList);
    }

    public FlowerDTO() {
    }

    public FlowerDTO(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }
}
