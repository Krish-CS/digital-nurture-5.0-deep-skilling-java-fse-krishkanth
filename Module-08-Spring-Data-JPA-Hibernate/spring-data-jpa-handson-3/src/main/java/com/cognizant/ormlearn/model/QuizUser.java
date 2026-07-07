package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
@Entity
@Table(name="quiz_user")
public class QuizUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="us_id") private int id;
    @Column(name="us_name") private String name;
    public QuizUser() {}
    public int getId() { return id; }
    public String getName() { return name; }
}