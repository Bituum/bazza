package com.bituum.spring.mvc.models;


import javax.persistence.*;

@Entity
@Table(name="flower")
public class Flower {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="sort")
    private String sort;

    @Column(name="cost")
    private String cost;

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sort='" + sort + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }

    public Flower() {
    }

    public Flower(int id, String name, String sort, String cost) {
        this.id = id;
        this.name = name;
        this.sort = sort;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
