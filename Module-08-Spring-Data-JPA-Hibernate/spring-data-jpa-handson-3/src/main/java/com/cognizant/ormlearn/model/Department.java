package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
@Entity
@Table(name="department")
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="dp_id") private int id;
    @Column(name="dp_name") private String name;
    public Department() {}
    public int getId() { return id; }
    public String getName() { return name; }
}