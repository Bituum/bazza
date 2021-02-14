package com.bituum.spring.mvc.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="composition")
public class Composition {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Flower> compositionFlower;

    public List<Flower> getCompositionFlower() {
        return compositionFlower;
    }

    public void setCompositionFlower(List<Flower> compositionFlower) {
        this.compositionFlower = compositionFlower;
    }

    public Composition() {
    }

    public Composition(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", compositionFlower=" + compositionFlower +
                '}';
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


}
