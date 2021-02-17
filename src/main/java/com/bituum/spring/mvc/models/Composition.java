package com.bituum.spring.mvc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="composition", schema = "mydb")
public class Composition {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinTable(
            name="`flower-composition`",
            joinColumns = @JoinColumn(name="id_composition"),
            inverseJoinColumns = @JoinColumn(name = "id_flower")
    )
    private List<Flower> compositionFlower;

    public List<Flower> getCompositionFlower() {
        return compositionFlower;
    }

    public void setCompositionFlower(List<Flower> compositionFlower) {
        this.compositionFlower = compositionFlower;
    }

    /*public void addFlowerIntoComposition(List<Flower> flower){
        if(compositionFlower == null){
            compositionFlower = new ArrayList<>();
        }
        compositionFlower.addAll(flower);
    }*/

    public boolean isSelected(Integer compositionId){
        if(compositionId != null){
            return compositionId.equals(id);
        }
        return false;
    }


    public Composition() {
    }

    public Composition(int id, String title) {
        this.id = id;
        this.title = title;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composition that = (Composition) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(compositionFlower, that.compositionFlower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, compositionFlower);
    }
}
