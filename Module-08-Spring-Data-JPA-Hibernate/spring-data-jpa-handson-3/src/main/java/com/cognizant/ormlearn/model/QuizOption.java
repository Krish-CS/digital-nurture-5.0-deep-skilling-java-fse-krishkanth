package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
@Entity
@Table(name="quiz_options")
public class QuizOption {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="op_id") private int id;
    @Column(name="op_text") private String text;
    @Column(name="op_score") private double score;
    @Column(name="op_correct") private boolean correct;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="op_qn_id")
    private QuizQuestion question;

    public QuizOption() {}
    public int getId() { return id; }
    public String getText() { return text; }
    public double getScore() { return score; }
    public boolean isCorrect() { return correct; }
}