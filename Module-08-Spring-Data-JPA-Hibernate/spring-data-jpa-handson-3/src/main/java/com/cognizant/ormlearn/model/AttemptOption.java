package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
@Entity
@Table(name="attempt_option")
public class AttemptOption {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="ao_id") private int id;
    @Column(name="ao_selected") private boolean selected;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ao_aq_id")
    private AttemptQuestion attemptQuestion;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ao_op_id")
    private QuizOption option;

    public AttemptOption() {}
    public int getId() { return id; }
    public boolean isSelected() { return selected; }
    public QuizOption getOption() { return option; }
}