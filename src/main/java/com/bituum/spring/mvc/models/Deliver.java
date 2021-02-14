package com.bituum.spring.mvc.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="deliver")
public class Deliver {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date_of_execution")
    @Temporal(TemporalType.DATE)
    private Date dateOfExecution;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="date_of_registration")
    @Temporal(TemporalType.DATE)
    private Date dateOfRegestration;

    @Override
    public String toString() {
        return "Deliver{" +
                "id=" + id +
                ", dateOfExecution=" + dateOfExecution +
                ", dateOfRegestration=" + dateOfRegestration +
                '}';
    }

    public Deliver() {
    }

    public Deliver(int id, Date dateOfExecution, Date dateOfRegestration) {
        this.id = id;
        this.dateOfExecution = dateOfExecution;
        this.dateOfRegestration = dateOfRegestration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(Date dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public Date getDateOfRegestration() {
        return dateOfRegestration;
    }

    public void setDateOfRegestration(Date dateOfRegestration) {
        this.dateOfRegestration = dateOfRegestration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deliver deliver = (Deliver) o;
        return id == deliver.id &&
                Objects.equals(dateOfExecution, deliver.dateOfExecution) &&
                Objects.equals(dateOfRegestration, deliver.dateOfRegestration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfExecution, dateOfRegestration);
    }
}
