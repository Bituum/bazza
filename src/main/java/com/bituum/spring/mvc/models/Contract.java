package com.bituum.spring.mvc.models;


import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="contract")
public class Contract {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="totalsum")
    private int totalsum;

    @OneToMany
    @JoinColumn(name="id")
    private List<User> contractUser;

    @OneToMany
    @JoinColumn(name="id")
    private List<Deliver> contractDeliver;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private List<Composition> contractComposition;


    public Contract(int id, int totalsum) {
        this.id = id;
        this.totalsum = totalsum;
    }

    public Contract() {

    }

    public List<User> getContractUser() {
        return contractUser;
    }

    public void setContractUser(List<User> contractUser) {
        this.contractUser = contractUser;
    }

    public List<Deliver> getContractDeliver() {
        return contractDeliver;
    }

    public void setContractDeliver(List<Deliver> contractDeliver) {
        this.contractDeliver = contractDeliver;
    }

    public List<Composition> getContractComposition() {
        return contractComposition;
    }

    public void setContractComposition(List<Composition> contractComposition) {
        this.contractComposition = contractComposition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(int totalsum) {
        this.totalsum = totalsum;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", totalsum=" + totalsum +
                ", contractUser=" + contractUser +
                ", contractDeliver=" + contractDeliver +
                ", contractComposition=" + contractComposition +
                '}';
    }
}
