package com.spark.dao.model;

import javax.persistence.*;

/**
 * Created by Spark on 2/8/16.
 */
@Entity
@Table(name="DATA")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NAME2", nullable = false)
    private String name2;

    @Column(name = "NAME3", nullable = false)
    private String name3;

    @Override
    public String toString() {
        return "Data [id=" + id + ", name=" + name + "]";
    }
}
