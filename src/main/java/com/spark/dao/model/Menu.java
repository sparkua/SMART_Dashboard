package com.spark.dao.model;

import javax.persistence.*;

/**
 * Created by Spark on 1/24/16.
 */
@Entity
@Table (name="MENU")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Menu [id=" + id + ", name=" + name + "]";
    }

}
